<template>
<el-card class="box-card">
  <div>
    <el-switch
      class="switch"
      v-model="value"
      active-text="Echarts"
      inactive-text="Table"
      @change="switchChange"
      v-loading.fullscreen.lock="fullscreenLoading"
      element-loading-text="Loading"
    >
    </el-switch>

    <el-select
      v-model="monthOrYear"
      placeholder="请选择"
      class="month"
      @change="moyHandler"
      :style="echartSearchStyle"
    >
      <el-option
        v-for="item of monthOrYearSeletorEl"
        :label="item.lable"
        :value="item.value"
        :key="item.value"
      >
      </el-option>
    </el-select>

    <el-date-picker
      v-model="echartMonOrYear"
      :type="monthOrYearForDatePlugin"
      placeholder="请选择"
      class="month"
      @change="refreshEchartData"
      :value-format="moyFormat"
      :style="echartSearchStyle"
    >
    </el-date-picker>

    <el-form :inline="true" :style="searchStyle">
      <el-form-item label="搜索：">
        <el-date-picker
          v-model="search.startDate"
          type="date"
          placeholder="请选择开始日期"
          style="width:175px"
          format="yyyy-MM-dd"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="">
        <el-date-picker
          v-model="search.endDate"
          type="date"
          placeholder="请选择结束日期"
          style="width:175px"
          format="yyyy-MM-dd"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="">
        <el-input
          v-model="search.name"
          placeholder="请输入交易名称"
          style="width: 220px"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-select
          v-model="search.attribute"
          placeholder="请选择交易性质"
          style="width: 220px"
          clearable
        >
          <el-option
            v-for="item of attributes"
            :label="item.lable"
            :value="item.value"
            :key="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="">
        <el-select
          v-model="search.way"
          placeholder="请选择交易途径"
          style="width: 220px"
          clearable
        >
          <el-option
            v-for="item of ways"
            :label="item.lable"
            :value="item.value"
            :key="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="">
        <el-select
          v-model="search.isPay"
          placeholder="请选择支出/收入"
          style="width: 220px"
          clearable
        >
          <el-option
            v-for="item of isPays"
            :label="item.lable"
            :value="item.value"
            :key="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
          size="medium"
          type="primary"
          icon="el-icon-search"
          @click="handleSearch"
          >搜索</el-button
        >
        <el-button
          size="medium"
          type="primary"
          icon="el-icon-document-add"
          @click="showInsertDialog"
          >新增</el-button
        >
      </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      v-loading="loading"
      element-loading-text="Loading"
      border
      :style="tableStyle"
      highlight-current-row
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="40"></el-table-column>
      <el-table-column
        prop="name"
        label="交易名称"
        width="220"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="amount"
        label="发生金额"
        width="220"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="date"
        label="交易日期"
        width="220"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="attributeName"
        label="交易性质"
        width="220"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="wayName"
        label="交易途径"
        width="220"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="isPayName"
        label="支出/收入"
        width="208"
        align="center"
      ></el-table-column>
      <el-table-column label="操作" width="220" align="center">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="primary" size="medium"
            >编辑</el-button
          >
          <el-button
            @click="handleDelete(scope.row)"
            type="danger"
            size="medium"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="page.currentPage"
      :page-sizes="page.pageSizes"
      :page-size="page.pageSize"
      layout="sizes, prev, pager, next"
      :total="page.total"
      :style="tableStyle"
    >
    </el-pagination>
    <el-dialog :title="title" :visible.sync="dialogInsertVisible" width="30%">
      <el-card class="box-card">
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          size="medium"
          style=""
        >
          <el-form-item label="交易名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="发生金额" prop="amount">
            <el-input v-model="ruleForm.amount"></el-input>
          </el-form-item>
          <el-form-item label="交易日期" required>
            <el-form-item prop="date">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="ruleForm.date"
                style=""
              ></el-date-picker>
            </el-form-item>
          </el-form-item>
          <el-form-item label="交易性质" prop="attribute">
            <el-select
              v-model="ruleForm.attribute"
              placeholder="请选择性质"
              style=""
            >
              <el-option
                v-for="item of attributes"
                :label="item.lable"
                :value="item.value"
                :key="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="交易途径" prop="way">
            <el-select v-model="ruleForm.way" placeholder="请选择途径" style="">
              <el-option
                v-for="item of ways"
                :label="item.lable"
                :value="item.value"
                :key="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="支出/收入" prop="isPay">
            <el-select
              v-model="ruleForm.isPay"
              placeholder="请选择支出/收入"
              style=""
            >
              <el-option
                v-for="item of isPays"
                :label="item.lable"
                :value="item.value"
                :key="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-form>
      </el-card>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelForm('ruleForm')">取 消</el-button>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >确 定</el-button
        >
      </div>
    </el-dialog>
    <div>
      <div style="display: inline-block">
        <sum-echart
          :echartStyle="echartStyle"
          :sumEchartData="sumEchartData"
        ></sum-echart>
      </div>
      <div style="display: inline-block">
        <attr-echart
          :echartStyle="echartStyle"
          :attrEchartData="attrEchartData"
        ></attr-echart>
      </div>
    </div>
    <div>
      <div style="display: inline-block">
        <way-echart
          :echartStyle="echartStyle"
          :wayEchartData="wayEchartData"
        ></way-echart>
      </div>
      <div style="display: inline-block">
        <is-pay-echart
          :echartStyle="echartStyle"
          :isPayEchartData="isPayEchartData"
        ></is-pay-echart>
      </div>
    </div>
  </div>
</el-card>
</template>

<script>
import { dicReq, tranReq } from "../../api/money";
import sumEchart from "./money-sumEchart.vue";
import attrEchart from "./money-attrEchart.vue";
import wayEchart from "./money-wayEchart.vue";
import isPayEchart from "./money-isPayEchart.vue";
export default {
  components: {
    sumEchart,
    attrEchart,
    wayEchart,
    isPayEchart,
  },
  methods: {
    handleDelete(row) {
      let id = row.id;
      this.$confirm("确定删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.fullscreenLoading = true;
          tranReq("delete", {}, "/tran/" + id).then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.data,
                type: "success",
              });
              this.initTableData(
                this.page.currentPage + "/" + this.page.pageSize
              );
              this.fullscreenLoading = false;
              this.refreshEchartData();
            } else {
              this.$message({
                message: res.message,
                type: "error",
              });
              this.fullscreenLoading = false;
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    handleEdit(row) {
      console.log(row);
      this.ruleForm.name = row.name;
      this.ruleForm.amount = row.amount;
      this.ruleForm.date = new Date(row.date);
      this.ruleForm.attribute = row.attribute;
      this.ruleForm.way = row.way;
      this.ruleForm.isPay =row.isPay;
      this.ruleForm.id = row.id;
      this.dialogInsertVisible = true;
    },
    changeLoadingStatus() {
      setTimeout(() => {
        this.loading = false;
      }, 500);
    },
    switchChange() {
      if (!this.value) {
        this.loading = true;
        this.changeLoadingStatus();
        this.tableStyle.display = "";
        this.searchStyle.display = "";
        this.echartStyle.display = "none";
        this.echartSearchStyle.display = "none";
      } else {
        this.tableStyle.display = "none";
        this.searchStyle.display = "none";
        this.openFullScreen();
        this.echartStyle.display = "";
        this.echartSearchStyle.display = "";
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(this.multipleSelection);
    },
    initMoneyAttributes() {
      dicReq("MONEY_ATTR", "/dic/getDics/").then((res) => {
        if (res.code == 200) {
          for (let item of res.data) {
            let attribute = {};
            attribute.lable = item.dicValue;
            attribute.value = item.dicId;
            this.attributes.push(attribute);
          }
        }
      });
    },
    initMoneyWays() {
      dicReq("MONEY_WAY", "/dic/getDics/").then((res) => {
        if (res.code == 200) {
          for (let item of res.data) {
            let way = {};
            way.lable = item.dicValue;
            way.value = item.dicId;
            this.ways.push(way);
          }
        }
      });
    },
    initMoneyIsPays() {
      dicReq("MONEY_ISPAY", "/dic/getDics/").then((res) => {
        if (res.code == 200) {
          for (let item of res.data) {
            let isPay = {};
            isPay.lable = item.dicValue;
            isPay.value = item.dicId;
            this.isPays.push(isPay);
          }
        }
      });
    },
    initMonthOrYear() {
      dicReq("MONEY_MOY", "/dic/getDics/").then((res) => {
        if (res.code == 200) {
          for (let item of res.data) {
            let moy = {};
            moy.lable = item.dicValue;
            moy.value = item.dicId;
            this.monthOrYearSeletorEl.push(moy);
          }
        }
      });
    },
    initTableData(param) {
      dicReq(param, "/tran/").then((res) => {
        if (res.code == 200) {
          console.log(res.data);
          this.tableData = [];
          this.page.total = res.data.total;
          for (let item of res.data.records) {
            let tableData = {};
            tableData.id = item.id;
            tableData.name = item.name;
            tableData.amount = item.amount;
            tableData.date = item.date;
            tableData.attribute = item.attribute;
            tableData.attributeName = item.attributeName;
            tableData.way = item.way;
            tableData.wayName = item.wayName;
            tableData.isPay = item.isPay;
            tableData.isPayName = item.isPayName;
            this.tableData.push(tableData);
          }
        }
      });
    },
    handleCurrentChange(val) {
      this.page.currentPage = val;
      this.handleSearch();
    },
    handleSizeChange(val) {
      this.page.pageSize = val;
      this.handleSearch();
    },
    handleSearch() {
      this.fullscreenLoading = true;
      let url = this.page.currentPage + "/" + this.page.pageSize;
      tranReq("post", this.search, "/tran/query/" + url).then((res) => {
        if (res.code == 200) {
          console.log(res.data);
          this.tableData = [];
          this.page.total = res.data.total;
          for (let item of res.data.records) {
            let tableData = {};
            tableData.id = item.id;
            tableData.name = item.name;
            tableData.amount = item.amount;
            tableData.date = item.date;
            tableData.attribute = item.attribute;
            tableData.attributeName = item.attributeName;
            tableData.way = item.way;
            tableData.wayName = item.wayName;
            tableData.isPay = item.isPay;
            tableData.isPayName = item.isPayName;
            this.tableData.push(tableData);
          }
          this.fullscreenLoading = false;
        } else {
          this.$message({
            message: res.message,
            type: "error",
          });
          this.fullscreenLoading = false;
        }
      });
    },
    openFullScreen() {
      this.fullscreenLoading = true;
      setTimeout(() => {
        this.fullscreenLoading = false;
      }, 500);
    },
    submitForm(formName) {
      this.$refs[formName].clearValidate();
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.ruleForm.date = new Date(
            this.ruleForm.date.toLocaleDateString()
          );
          this.fullscreenLoading = true;
          let method = "post";
          if (this.ruleForm.id) {
            method = "put";
          }
          tranReq(method, this.ruleForm, "/tran/").then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.data,
                type: "success",
              });
              this.handleSearch(
                this.page.currentPage + "/" + this.page.pageSize
              );
              this.dialogInsertVisible = false;
              this.fullscreenLoading = false;
              this.refreshEchartData();
            } else {
              this.$message({
                message: res.message,
                type: "error",
              });
              this.fullscreenLoading = false;
            }
          });
        }
      });
    },
    cancelForm(formName) {
      this.dialogInsertVisible = false;
      this.$refs[formName].clearValidate();
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    showInsertDialog() {
      this.ruleForm = {
        //新增、更新表单数据
        name: "",
        amount: "",
        attribute: "",
        way: "",
        date: "",
        isPay: "",
        id: "",
      };
      this.dialogInsertVisible = true;
    },
    async initSumEchratData() {
      await dicReq("", "/echart/sum").then((res) => {
        if (res.code === 200) {
          this.sumEchartData = [];
          let dataFromServe = res.data;
          for (let item of dataFromServe) {
            let itemArray = [];
            itemArray[0] = item.date;
            itemArray[1] = parseFloat(item.amount).toFixed(2);
            this.sumEchartData.push(itemArray);
          }
        } else {
          this.$message({
            message: res.data,
            type: "error",
          });
        }
      });
    },
    async initAttrEchratData() {
      await dicReq("", "/echart/attr/" + this.echartMonOrYear).then((res) => {
        if (res.code === 200) {
          this.attrEchartData = [];
          let dataFromServe = res.data;
          for (let item of dataFromServe) {
            if (item.attrName != null) {
              let itemObj = {};
              itemObj.value = parseFloat(item.amount).toFixed(2);
              itemObj.name = item.attrName;
              this.attrEchartData.push(itemObj);
            }
          }
          console.log(this.attrEchartData);
          if (this.attrEchartData.length === 0) {
            this.$message({
              message: "当前时间段无数据展示",
              type: "error",
            });
          }
        } else {
          this.$message({
            message: res.message,
            type: "error",
          });
        }
      });
    },
    async initWayEchratData() {
      await dicReq("", "/echart/way/" + this.echartMonOrYear).then((res) => {
        if (res.code === 200) {
          this.wayEchartData = [];
          let dataFromServe = res.data;
          for (let item of dataFromServe) {
            if (item.attrName != null) {
              let itemObj = {};
              itemObj.value = parseFloat(item.amount).toFixed(2);
              itemObj.name = item.attrName;
              this.wayEchartData.push(itemObj);
            }
          }
          console.log(this.wayEchartData);
        } else {
          this.$message({
            message: res.message,
            type: "error",
          });
        }
      });
    },
    async initIsPayEchratData() {
      await dicReq("", "/echart/ispay/" + this.echartMonOrYear).then((res) => {
        if (res.code === 200) {
          this.isPayEchartData = [];
          let dataFromServe = res.data;
          for (let item of dataFromServe) {
            if (item.attrName != null) {
              let itemObj = {};
              itemObj.value = parseFloat(item.amount).toFixed(2);
              itemObj.name = item.attrName;
              this.isPayEchartData.push(itemObj);
            }
          }
          console.log(this.isPayEchartData);
        } else {
          this.$message({
            message: res.message,
            type: "error",
          });
        }
      });
    },
    refreshEchartData() {
      this.fullscreenLoading = true;
      this.initSumEchratData();
      this.initAttrEchratData();
      this.initWayEchratData();
      this.initIsPayEchratData();
      this.fullscreenLoading = false;
    },
    moyHandler() {
      if (this.monthOrYear == 0) {
        this.monthOrYearForDatePlugin = "month";
        this.moyFormat = "yyyy-MM";
        this.echartMonOrYear = "";
      } else {
        this.monthOrYearForDatePlugin = "year";
        this.moyFormat = "yyyy";
        this.echartMonOrYear = "";
      }
    },
  },
  created() {
    this.initMonthOrYear();
    this.initMoneyAttributes();
    this.initMoneyWays();
    this.initMoneyIsPays();
    this.initTableData(this.page.currentPage + "/" + this.page.pageSize);
    this.changeLoadingStatus();
    this.refreshEchartData();
  },
  mounted() {},
  data() {
    let validateNumber = (rule, value, callback) => {
      console.log(rule);
      if (!/^[0-9]+([.]{1}[0-9]+){0,1}$/.test(value)) {
        callback(new Error("请输入正确的数字"));
      } else {
        callback();
      }
    };
    return {
      title: "详情", //表单标题
      loading: true, //加载flag
      dialogFormVisible: false, //对话框flag
      dialogInsertVisible: false, //新增表单对话框flag
      value: true,
      fullscreenLoading: false,
      echartMonOrYear: new Date().getFullYear().toString(),
      sumEchartData: [],
      attrEchartData: [],
      wayEchartData: [],
      isPayEchartData: [],
      monthOrYear: "",
      monthOrYearSeletorEl: [],
      monthOrYearForDatePlugin: "",
      moyFormat: "yyyy",
      page: {
        pageSizes: [10, 20, 30, 40],
        pageSize: 10,
        currentPage: 1,
        total: 0,
      },
      tableStyle: {
        display: "none",
        width: "1570px",
      },
      echartStyle: {
        width: "739px",
        height: "500px",
        marginLeft: "50px",
        display: "",
      },
      searchStyle: {
        display: "none",
        marginLeft: "35px",
        marginBottom: "20px",
      },
      echartSearchStyle: {
        display: "",
      },
      editForm: {
        //表单数据
        name: "",
        amount: "",
        date: "",
        attribute: "",
        way: "",
        isPay: "",
      },
      formLabelWidth: "120px", //表单宽度
      multipleSelection: [], //多选数据
      search: {
        startDate: "",
        endDate: "",
        name: "",
        attribute: "",
        way: "",
        isPay: "",
      },
      tableData: [], //列表数据
      attributes: [],
      ways: [],
      isPays: [],
      ruleForm: {
        //新增、更新表单数据
        name: "",
        amount: "",
        attribute: "",
        way: "",
        date: "",
        isPay: "",
        id: "",
      },
      rules: {
        name: [{ required: true, message: "请输入交易名称", trigger: "blur" }],
        amount: [
          { required: true, validator: validateNumber, trigger: "blur" },
        ],
        attribute: [
          { required: true, message: "请选择交易性质", trigger: "blur" },
        ],
        way: [{ required: true, message: "请选择交易途径", trigger: "blur" }],
        isPay: [
          { required: true, message: "请选择支出/收入", trigger: "blur" },
        ],
        date: [
          {
            type: "date",
            required: true,
            message: "请选择交易日期",
            trigger: "blur",
          },
        ],
      },
    };
  },
};
</script>
<style scoped>
.switch {
  margin-bottom: 50px;
  margin-left: 25px;
}
.month {
  top: -22px;
  margin-left: 40px;
}
</style>