<template>
  <div id="main3" :style="echartStyle"></div>
</template>

<script>
export default {
  name: "isPayEchart",
  data() {
    return {
        options: {
        title: {
          text: "支出/收入占比图",
          left: "center",
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          top: "5%",
          left: "center",
        },
        series: [
          {
            name: "金额数量",
            type: "pie",
            radius: ["40%", "70%"],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: "#fff",
              borderWidth: 2,
            },
            label: {
              show: false,
              position: "center",
            },
            emphasis: {
              label: {
                show: true,
                fontSize: "40",
                fontWeight: "bold",
              },
            },
            labelLine: {
              show: false,
            },
            data: [],
          },
        ],
        }
    };
  },
  mounted() {
    this.echartsInit();
  },
  watch: {
    isPayEchartData: {
      deep: true,
      handler: function () {
        this.initColumn();
        this.echartsInit();
      },
    },
  },
  props: {
    echartStyle: {
      type: Object,
    },
    isPayEchartData: {
      type: Array
    }
  },
  created() {
    this.initColumn();
  },
  methods: {
    echartsInit() {
      this.$echarts.init(document.getElementById("main3")).setOption(this.options);
    },
    initColumn(){
        console.log(this.isPayEchartData);
        this.options.series[0].data = this.isPayEchartData;
    }
  },
};
</script>
<style scoped>
</style>

