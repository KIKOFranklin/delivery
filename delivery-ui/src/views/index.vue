<template>
  <el-container style="">
    <leftnav></leftnav>
    <el-card class="box-card">
      <el-container>
        <el-header style="text-align: right; font-size: 12px;">
          <span class="webTitle">KIKOFranklinClub</span>
          <headnav></headnav>
          <span>王家豪</span>
        </el-header>
        <router-view/>
      </el-container>
    </el-card>
  </el-container>
</template>
<script>
import leftnav from "../components/menu-left.vue"
import headnav from "../components/menu-head.vue"
export default {
  name: 'index',
  created(){
    this.$message({
      message: '欢迎使用记账本!',
      type: 'success'
    })
  },
  components: {
    leftnav,
    headnav
  }
}
</script>
<style scoped>
  .el-header {
    background-color: white;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
    height: 100%;
  }

  .webTitle {
    margin-right: 1350px; 
    font-size:20px !important;
  }
</style>
