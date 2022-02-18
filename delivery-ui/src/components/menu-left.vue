<template>
<el-card class="box-card">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']" router>
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-goods"></i>日常账单记录</template>
        <el-menu-item-group>
          <el-menu-item index="/moneytable"><i class="el-icon-pie-chart"></i>账单图表</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
</el-card>
</template>

<script>
export default {
    name: "leftnav",
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
