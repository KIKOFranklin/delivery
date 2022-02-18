<template>
<div>
  <el-card class="box-card" style="width:560px; height:500px">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" size="medium" style="width:500px; height: 500px">
      <el-form-item label="交易名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="发生金额" prop="amount">
        <el-input v-model="ruleForm.amount"></el-input>
      </el-form-item>
      <el-form-item label="交易日期" required>
          <el-form-item prop="date">
            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date" style="width: 100%;"></el-date-picker>
          </el-form-item>
      </el-form-item>
      <el-form-item label="交易性质" prop="attribute" >
        <el-select v-model="ruleForm.attribute" placeholder="请选择性质" style="width:400px">
          <el-option v-for="item of attributes" :label="item.lable" :value="item.value" :key="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="交易途径" prop="way" >
        <el-select v-model="ruleForm.way" placeholder="请选择途径" style="width:400px">
          <el-option v-for="item of ways" :label="item.lable" :value="item.value" :key="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="支出/收入" prop="isPay" >
        <el-select v-model="ruleForm.isPay" placeholder="请选择支出/收入" style="width:400px">
          <el-option v-for="item of isPays" :label="item.lable" :value="item.value" :key="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</div>
</template>

<script>
export default {
    data() {
      return {
        attributes:[
          {
            lable: "餐饮费",
            value: 0
          },
          {
            lable: "生活物品",
            value: 1
          },
          {
            lable: "全款购物",
            value: 2
          },
          {
            lable: "分期购物",
            value: 3
          },
          {
            lable: "水电费",
            value: 4
          },
          {
            lable: "交通费",
            value: 5
          },
          {
            lable: "工资",
            value: 6
          },
          {
            lable: "红包",
            value: 7
          },
          {
            lable: "奖金",
            value: 8
          },
        ],
        ways: [
          {
            lable: "微信支付",
            value: 0
          },
          {
            lable: "支付宝支付",
            value: 1
          },
          {
            lable: "银行卡转账",
            value: 2
          },
          {
            lable: "现金支付",
            value: 3
          }
        ],
        isPays: [
          {
            lable: "支出",
            value: 0
          },
          {
            lable: "收入",
            value: 1
          }
        ],
        ruleForm: {
          name: '',
          amount: '',
          attribute: '',
          way: '',
          date: '',
          isPay : ''
        },
        rules: {
          name: [
            { required: true, message: '请输入交易名称', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '请输入交易金额', trigger: 'blur' }
          ],
          attribute: [
            { required: true, message: '请选择交易性质', trigger: 'change' }
          ],
          way: [
            { required: true, message: '请选择交易途径', trigger: 'change' }
          ],
          isPay: [
            { required: true, message: '请选择支出/收入', trigger: 'change' }
          ],
          date: [
            { type: 'date', required: true, message: '请选择交易日期', trigger: 'change' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$message({
              message: '后台接口暂未开放！',
              type: 'error'
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

