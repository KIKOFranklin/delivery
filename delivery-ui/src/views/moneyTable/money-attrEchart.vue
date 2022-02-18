<template>
  <div id="main1" :style="echartStyle"></div>
</template>

<script>
export default {
  name: "attrEchart",
  data() {
    return {
      options:{
        title: {
          text: "交易性质占比图",
          left: "center",
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          left: "left",
        },
        series: [
          {
            name: "金额数量",
            type: "pie",
            radius: "50%",
            data: [],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],
      }
    };
  },
  mounted() {
    this.echartsInit();
  },
  props: {
    echartStyle: {
      type: Object,
    },
    attrEchartData: {
      type: Array
    }
  },
  watch: {
    attrEchartData: {
      deep: true,
      handler: function () {
        this.initColumn();
        this.echartsInit();
      },
    },
  },
  created() {
    this.initColumn();
  },
  methods: {
    echartsInit() {
      this.$echarts.init(document.getElementById("main1")).setOption(this.options);
    },
    initColumn(){
        console.log(this.attrEchartData);
        this.options.series[0].data = this.attrEchartData;
    }
  },
};
</script>

