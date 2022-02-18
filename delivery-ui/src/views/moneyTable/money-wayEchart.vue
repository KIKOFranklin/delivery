<template>
  <div id="main2" :style="echartStyle"></div>
</template>

<script>
export default {
  name: "wayEchart",
  data() {
    return {
      options: {
        title: {
          text: "交易途径占比图",
          left: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
        },
        legend: {
          bottom: 10,
          left: "center",
          data: [],
        },
        series: [
          {
            name: "金额数量",
            type: "pie",
            radius: "65%",
            center: ["50%", "50%"],
            selectedMode: "single",
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
  watch: {
    wayEchartData: {
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
    wayEchartData: {
      type: Array
    }
  },
  created(){
    this.initColumn();
  },
  methods: {
    echartsInit() {
      this.$echarts.init(document.getElementById("main2")).setOption(this.options);
    },
    initColumn(){
        console.log(this.wayEchartData);
        this.options.series[0].data = this.wayEchartData;
        this.wayEchartData.forEach(t => {
          this.options.legend.data.push(t.name);
        })
    }
  },
};
</script>

