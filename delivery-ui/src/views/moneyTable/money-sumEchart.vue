<template>
  <div id="main" :style="echartStyle" ref="myEchart"></div>
</template>

<script>
export default {
  name: "sumEchart",
  data() {
    return {
      dateList: [],
      valueList: [],
      options: {
        visualMap: [
          {
            show: false,
            type: "continuous",
            seriesIndex: 0,
            min: 0,
            max: 400,
          },
          {
            show: false,
            type: "continuous",
            seriesIndex: 1,
            dimension: 0,
            min: 0,
            max: 0,
          },
        ],
        title: [
          {
            left: "center",
            text: "每日支出金额直线图",
          },
        ],
        tooltip: {
          trigger: "axis",
        },
        xAxis: [
          {
            data: [],
          },
        ],
        yAxis: [{}],
        grid: [
          {
            bottom: "30%",
          },
        ],
        series: [
          {
            type: "line",
            showSymbol: false,
            data: [],
          },
        ],
      },
    };
  },
  mounted() {
    this.echartsInit();
  },
  props: {
    echartStyle: {
      type: Object,
    },
    sumEchartData: {
      type: Array,
    },
  },
  watch: {
    sumEchartData: {
      deep: true,
      handler: function () {
        this.initColumn();
        this.echartsInit();
      },
    },
  },
  created(){
      this.initColumn();
  },
  methods: {
    echartsInit() {
      this.$echarts.init(document.getElementById("main")).setOption(this.options);
    },
    initColumn(){
        this.dateList = this.sumEchartData.map(t => t[0]);
        this.valueList = this.sumEchartData.map(t => t[1]);
        this.options.visualMap[1].max = this.dateList.length - 1;
        this.options.xAxis[0].data = this.dateList;
        this.options.series[0].data = this.valueList;
    }
  },
};
</script>
<style scoped>
</style>

