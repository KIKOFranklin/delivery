(function(e){function t(t){for(var r,i,o=t[0],s=t[1],c=t[2],m=0,h=[];m<o.length;m++)i=o[m],Object.prototype.hasOwnProperty.call(n,i)&&n[i]&&h.push(n[i][0]),n[i]=0;for(r in s)Object.prototype.hasOwnProperty.call(s,r)&&(e[r]=s[r]);u&&u(t);while(h.length)h.shift()();return l.push.apply(l,c||[]),a()}function a(){for(var e,t=0;t<l.length;t++){for(var a=l[t],r=!0,o=1;o<a.length;o++){var s=a[o];0!==n[s]&&(r=!1)}r&&(l.splice(t--,1),e=i(i.s=a[0]))}return e}var r={},n={app:0},l=[];function i(t){if(r[t])return r[t].exports;var a=r[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=e,i.c=r,i.d=function(e,t,a){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)i.d(a,r,function(t){return e[t]}.bind(null,r));return a},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],s=o.push.bind(o);o.push=t,o=o.slice();for(var c=0;c<o.length;c++)t(o[c]);var u=s;l.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"0624":function(e,t,a){},"078f":function(e,t,a){"use strict";a("0624")},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r=a("2b0e"),n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},l=[],i={name:"App"},o=i,s=a("2877"),c=Object(s["a"])(o,n,l,!1,null,null,null),u=c.exports,m=a("5c96"),h=a.n(m),d=(a("0fae"),a("8c4f")),p=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{},[a("leftnav"),a("el-card",{staticClass:"box-card"},[a("el-container",[a("el-header",{staticStyle:{"text-align":"right","font-size":"12px"}},[a("span",{staticClass:"webTitle"},[e._v("KIKOFranklinClub")]),a("headnav"),a("span",[e._v("王家豪")])],1),a("router-view")],1)],1)],1)},f=[],y=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",{staticClass:"box-card"},[a("el-aside",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[a("el-menu",{attrs:{"default-openeds":["1","3"],router:""}},[a("el-submenu",{attrs:{index:"1"}},[a("template",{slot:"title"},[a("i",{staticClass:"el-icon-goods"}),e._v("日常账单记录")]),a("el-menu-item-group",[a("el-menu-item",{attrs:{index:"/moneytable"}},[a("i",{staticClass:"el-icon-pie-chart"}),e._v("账单图表")])],1)],2)],1)],1)],1)},g=[],b={name:"leftnav",methods:{handleOpen:function(e,t){console.log(e,t)},handleClose:function(e,t){console.log(e,t)}}},v=b,w=Object(s["a"])(v,y,g,!1,null,"8fc567a0",null),x=w.exports,S=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dropdown",[a("i",{staticClass:"el-icon-user",staticStyle:{"margin-right":"15px"}}),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",[e._v("查看")]),a("el-dropdown-item",[e._v("新增")]),a("el-dropdown-item",[e._v("删除")])],1)],1)},F=[],E={name:"headnav",data:function(){return{activeIndex:"1",activeIndex2:"1"}},methods:{handleSelect:function(e,t){console.log(e,t)}}},D=E,k=Object(s["a"])(D,S,F,!1,null,null,null),O=k.exports,P={name:"index",created:function(){this.$message({message:"欢迎使用记账本!",type:"success"})},components:{leftnav:x,headnav:O}},$=P,_=(a("8f88"),Object(s["a"])($,p,f,!1,null,"00f3a2ba",null)),C=_.exports,I=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"login-wrap"},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm login-container",attrs:{"label-position":"left",model:e.ruleForm,rules:e.rules,"label-width":"0px"}},[a("h3",{staticClass:"title"},[e._v("Tallybook Login")]),a("el-form-item",{attrs:{prop:"username"}},[a("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:e.ruleForm.username,callback:function(t){e.$set(e.ruleForm,"username",t)},expression:"ruleForm.username"}})],1),a("el-form-item",{attrs:{prop:"password"}},[a("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},model:{value:e.ruleForm.password,callback:function(t){e.$set(e.ruleForm,"password",t)},expression:"ruleForm.password"}})],1),a("el-form-item",{staticStyle:{width:"100%"}},[a("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",loading:e.logining},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("登录")])],1)],1)],1)},j=[],L=a("bc3a"),M=a.n(L),Y=function(e,t,a){return M()({method:e,url:t,headers:{"Content-Type":"application/json",token:window.sessionStorage.getItem("token")},data:a}).then((function(e){if(403!==e.data.code)return e.data;$e.push({name:"login",params:{expire:"1"}})}))},N=function(e,t){return M()({method:e,url:t,headers:{token:window.sessionStorage.getItem("token")}}).then((function(e){if(403!==e.data.code)return e.data;$e.push({name:"login",params:{expire:"1"}})}))},z="http://host.docker.internal:8085",T=function(e,t){return N("get",z+t+e)},q=function(e,t,a){return Y(e,z+a,t)},A={name:"login",data:function(){return{logining:!1,rememberpwd:!1,ruleForm:{username:"",password:"",code:"",randomStr:"",codeimg:""},rules:{username:[{required:!0,message:"请输入账号",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}],code:[{required:!0,message:"请输入验证码",trigger:"blur"}]}}},created:function(){1==this.$route.params.expire&&this.$message({type:"error",message:"用户信息失效，请重新登录！"})},methods:{submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return t.getcode(),t.$message.error("请输入用户名密码！"),t.logining=!1,!1;q("post",t.ruleForm,"/jwt/login/"+t.ruleForm.username+"/"+t.ruleForm.password).then((function(e){200==e.code?(window.vuethis=t,setTimeout((function(){t.$store.commit("setToken",e.data),window.sessionStorage.setItem("token",e.data),t.$router.push({path:"/moneytable"})}),1e3)):t.$message({message:e.message,type:"error"})}))}))}}},V=A,R=(a("c4b6"),Object(s["a"])(V,I,j,!1,null,"8734d0b2",null)),B=R.exports,W=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",{staticClass:"box-card"},[a("div",[a("el-switch",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.fullscreenLoading,expression:"fullscreenLoading",modifiers:{fullscreen:!0,lock:!0}}],staticClass:"switch",attrs:{"active-text":"Echarts","inactive-text":"Table","element-loading-text":"Loading"},on:{change:e.switchChange},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}),a("el-select",{staticClass:"month",style:e.echartSearchStyle,attrs:{placeholder:"请选择"},on:{change:e.moyHandler},model:{value:e.monthOrYear,callback:function(t){e.monthOrYear=t},expression:"monthOrYear"}},e._l(e.monthOrYearSeletorEl,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1),a("el-date-picker",{staticClass:"month",style:e.echartSearchStyle,attrs:{type:e.monthOrYearForDatePlugin,placeholder:"请选择","value-format":e.moyFormat},on:{change:e.refreshEchartData},model:{value:e.echartMonOrYear,callback:function(t){e.echartMonOrYear=t},expression:"echartMonOrYear"}}),a("el-form",{style:e.searchStyle,attrs:{inline:!0}},[a("el-form-item",{attrs:{label:"搜索："}},[a("el-date-picker",{staticStyle:{width:"175px"},attrs:{type:"date",placeholder:"请选择开始日期",format:"yyyy-MM-dd"},model:{value:e.search.startDate,callback:function(t){e.$set(e.search,"startDate",t)},expression:"search.startDate"}})],1),a("el-form-item",{attrs:{label:""}},[a("el-date-picker",{staticStyle:{width:"175px"},attrs:{type:"date",placeholder:"请选择结束日期",format:"yyyy-MM-dd"},model:{value:e.search.endDate,callback:function(t){e.$set(e.search,"endDate",t)},expression:"search.endDate"}})],1),a("el-form-item",{attrs:{label:""}},[a("el-input",{staticStyle:{width:"220px"},attrs:{placeholder:"请输入交易名称"},model:{value:e.search.name,callback:function(t){e.$set(e.search,"name",t)},expression:"search.name"}})],1),a("el-form-item",{attrs:{label:""}},[a("el-select",{staticStyle:{width:"220px"},attrs:{placeholder:"请选择交易性质",clearable:""},model:{value:e.search.attribute,callback:function(t){e.$set(e.search,"attribute",t)},expression:"search.attribute"}},e._l(e.attributes,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:""}},[a("el-select",{staticStyle:{width:"220px"},attrs:{placeholder:"请选择交易途径",clearable:""},model:{value:e.search.way,callback:function(t){e.$set(e.search,"way",t)},expression:"search.way"}},e._l(e.ways,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:""}},[a("el-select",{staticStyle:{width:"220px"},attrs:{placeholder:"请选择支出/收入",clearable:""},model:{value:e.search.isPay,callback:function(t){e.$set(e.search,"isPay",t)},expression:"search.isPay"}},e._l(e.isPays,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",[a("el-button",{attrs:{size:"medium",type:"primary",icon:"el-icon-search"},on:{click:e.handleSearch}},[e._v("搜索")]),a("el-button",{attrs:{size:"medium",type:"primary",icon:"el-icon-document-add"},on:{click:e.showInsertDialog}},[e._v("新增")])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],style:e.tableStyle,attrs:{data:e.tableData,"element-loading-text":"Loading",border:"","highlight-current-row":""},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"40"}}),a("el-table-column",{attrs:{prop:"name",label:"交易名称",width:"220",align:"center"}}),a("el-table-column",{attrs:{prop:"amount",label:"发生金额",width:"220",align:"center"}}),a("el-table-column",{attrs:{prop:"date",label:"交易日期",width:"220",align:"center"}}),a("el-table-column",{attrs:{prop:"attributeName",label:"交易性质",width:"220",align:"center"}}),a("el-table-column",{attrs:{prop:"wayName",label:"交易途径",width:"220",align:"center"}}),a("el-table-column",{attrs:{prop:"isPayName",label:"支出/收入",width:"208",align:"center"}}),a("el-table-column",{attrs:{label:"操作",width:"220",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(a){return e.handleEdit(t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{type:"danger",size:"medium"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("el-pagination",{style:e.tableStyle,attrs:{"current-page":e.page.currentPage,"page-sizes":e.page.pageSizes,"page-size":e.page.pageSize,layout:"sizes, prev, pager, next",total:e.page.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){return e.$set(e.page,"currentPage",t)},"update:current-page":function(t){return e.$set(e.page,"currentPage",t)}}}),a("el-dialog",{attrs:{title:e.title,visible:e.dialogInsertVisible,width:"30%"},on:{"update:visible":function(t){e.dialogInsertVisible=t}}},[a("el-card",{staticClass:"box-card"},[a("el-form",{ref:"ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px",size:"medium"}},[a("el-form-item",{attrs:{label:"交易名称",prop:"name"}},[a("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1),a("el-form-item",{attrs:{label:"发生金额",prop:"amount"}},[a("el-input",{model:{value:e.ruleForm.amount,callback:function(t){e.$set(e.ruleForm,"amount",t)},expression:"ruleForm.amount"}})],1),a("el-form-item",{attrs:{label:"交易日期",required:""}},[a("el-form-item",{attrs:{prop:"date"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:e.ruleForm.date,callback:function(t){e.$set(e.ruleForm,"date",t)},expression:"ruleForm.date"}})],1)],1),a("el-form-item",{attrs:{label:"交易性质",prop:"attribute"}},[a("el-select",{attrs:{placeholder:"请选择性质"},model:{value:e.ruleForm.attribute,callback:function(t){e.$set(e.ruleForm,"attribute",t)},expression:"ruleForm.attribute"}},e._l(e.attributes,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"交易途径",prop:"way"}},[a("el-select",{attrs:{placeholder:"请选择途径"},model:{value:e.ruleForm.way,callback:function(t){e.$set(e.ruleForm,"way",t)},expression:"ruleForm.way"}},e._l(e.ways,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"支出/收入",prop:"isPay"}},[a("el-select",{attrs:{placeholder:"请选择支出/收入"},model:{value:e.ruleForm.isPay,callback:function(t){e.$set(e.ruleForm,"isPay",t)},expression:"ruleForm.isPay"}},e._l(e.isPays,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){return e.cancelForm("ruleForm")}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("确 定")])],1)],1),a("div",[a("div",{staticStyle:{display:"inline-block"}},[a("sum-echart",{attrs:{echartStyle:e.echartStyle,sumEchartData:e.sumEchartData}})],1),a("div",{staticStyle:{display:"inline-block"}},[a("attr-echart",{attrs:{echartStyle:e.echartStyle,attrEchartData:e.attrEchartData}})],1)]),a("div",[a("div",{staticStyle:{display:"inline-block"}},[a("way-echart",{attrs:{echartStyle:e.echartStyle,wayEchartData:e.wayEchartData}})],1),a("div",{staticStyle:{display:"inline-block"}},[a("is-pay-echart",{attrs:{echartStyle:e.echartStyle,isPayEchartData:e.isPayEchartData}})],1)])],1)])},H=[],J=a("1da1"),K=a("b85c"),X=(a("96cf"),a("b0c0"),a("ac1f"),a("841c"),a("b680"),a("d3b7"),a("25f0"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{ref:"myEchart",style:e.echartStyle,attrs:{id:"main"}})}),G=[],Q=(a("d81d"),{name:"sumEchart",data:function(){return{dateList:[],valueList:[],options:{visualMap:[{show:!1,type:"continuous",seriesIndex:0,min:0,max:400},{show:!1,type:"continuous",seriesIndex:1,dimension:0,min:0,max:0}],title:[{left:"center",text:"每日支出金额直线图"}],tooltip:{trigger:"axis"},xAxis:[{data:[]}],yAxis:[{}],grid:[{bottom:"30%"}],series:[{type:"line",showSymbol:!1,data:[]}]}}},mounted:function(){this.echartsInit()},props:{echartStyle:{type:Object},sumEchartData:{type:Array}},watch:{sumEchartData:{deep:!0,handler:function(){this.initColumn(),this.echartsInit()}}},created:function(){this.initColumn()},methods:{echartsInit:function(){this.$echarts.init(document.getElementById("main")).setOption(this.options)},initColumn:function(){this.dateList=this.sumEchartData.map((function(e){return e[0]})),this.valueList=this.sumEchartData.map((function(e){return e[1]})),this.options.visualMap[1].max=this.dateList.length-1,this.options.xAxis[0].data=this.dateList,this.options.series[0].data=this.valueList}}}),U=Q,Z=Object(s["a"])(U,X,G,!1,null,"b2314c14",null),ee=Z.exports,te=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{style:e.echartStyle,attrs:{id:"main1"}})},ae=[],re={name:"attrEchart",data:function(){return{options:{title:{text:"交易性质占比图",left:"center"},tooltip:{trigger:"item"},legend:{orient:"vertical",left:"left"},series:[{name:"金额数量",type:"pie",radius:"50%",data:[],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}}},mounted:function(){this.echartsInit()},props:{echartStyle:{type:Object},attrEchartData:{type:Array}},watch:{attrEchartData:{deep:!0,handler:function(){this.initColumn(),this.echartsInit()}}},created:function(){this.initColumn()},methods:{echartsInit:function(){this.$echarts.init(document.getElementById("main1")).setOption(this.options)},initColumn:function(){console.log(this.attrEchartData),this.options.series[0].data=this.attrEchartData}}},ne=re,le=Object(s["a"])(ne,te,ae,!1,null,null,null),ie=le.exports,oe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{style:e.echartStyle,attrs:{id:"main2"}})},se=[],ce=(a("159b"),{name:"wayEchart",data:function(){return{options:{title:{text:"交易途径占比图",left:"center"},tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{bottom:10,left:"center",data:[]},series:[{name:"金额数量",type:"pie",radius:"65%",center:["50%","50%"],selectedMode:"single",data:[],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}}},mounted:function(){this.echartsInit()},watch:{wayEchartData:{deep:!0,handler:function(){this.initColumn(),this.echartsInit()}}},props:{echartStyle:{type:Object},wayEchartData:{type:Array}},created:function(){this.initColumn()},methods:{echartsInit:function(){this.$echarts.init(document.getElementById("main2")).setOption(this.options)},initColumn:function(){var e=this;console.log(this.wayEchartData),this.options.series[0].data=this.wayEchartData,this.wayEchartData.forEach((function(t){e.options.legend.data.push(t.name)}))}}}),ue=ce,me=Object(s["a"])(ue,oe,se,!1,null,null,null),he=me.exports,de=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{style:e.echartStyle,attrs:{id:"main3"}})},pe=[],fe={name:"isPayEchart",data:function(){return{options:{title:{text:"支出/收入占比图",left:"center"},tooltip:{trigger:"item"},legend:{top:"5%",left:"center"},series:[{name:"金额数量",type:"pie",radius:["40%","70%"],avoidLabelOverlap:!1,itemStyle:{borderRadius:10,borderColor:"#fff",borderWidth:2},label:{show:!1,position:"center"},emphasis:{label:{show:!0,fontSize:"40",fontWeight:"bold"}},labelLine:{show:!1},data:[]}]}}},mounted:function(){this.echartsInit()},watch:{isPayEchartData:{deep:!0,handler:function(){this.initColumn(),this.echartsInit()}}},props:{echartStyle:{type:Object},isPayEchartData:{type:Array}},created:function(){this.initColumn()},methods:{echartsInit:function(){this.$echarts.init(document.getElementById("main3")).setOption(this.options)},initColumn:function(){console.log(this.isPayEchartData),this.options.series[0].data=this.isPayEchartData}}},ye=fe,ge=Object(s["a"])(ye,de,pe,!1,null,"0779c6e4",null),be=ge.exports,ve={components:{sumEchart:ee,attrEchart:ie,wayEchart:he,isPayEchart:be},methods:{handleDelete:function(e){var t=this,a=e.id;this.$confirm("确定删除?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.fullscreenLoading=!0,q("delete",{},"/tran/"+a).then((function(e){200==e.code?(t.$message({message:e.data,type:"success"}),t.initTableData(t.page.currentPage+"/"+t.page.pageSize),t.fullscreenLoading=!1,t.refreshEchartData()):(t.$message({message:e.message,type:"error"}),t.fullscreenLoading=!1)}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},handleEdit:function(e){console.log(e),this.ruleForm.name=e.name,this.ruleForm.amount=e.amount,this.ruleForm.date=new Date(e.date),this.ruleForm.attribute=e.attribute,this.ruleForm.way=e.way,this.ruleForm.isPay=e.isPay,this.ruleForm.id=e.id,this.dialogInsertVisible=!0},changeLoadingStatus:function(){var e=this;setTimeout((function(){e.loading=!1}),500)},switchChange:function(){this.value?(this.tableStyle.display="none",this.searchStyle.display="none",this.openFullScreen(),this.echartStyle.display="",this.echartSearchStyle.display=""):(this.loading=!0,this.changeLoadingStatus(),this.tableStyle.display="",this.searchStyle.display="",this.echartStyle.display="none",this.echartSearchStyle.display="none")},handleSelectionChange:function(e){this.multipleSelection=e,console.log(this.multipleSelection)},initMoneyAttributes:function(){var e=this;T("MONEY_ATTR","/dic/getDics/").then((function(t){if(200==t.code){var a,r=Object(K["a"])(t.data);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.lable=n.dicValue,l.value=n.dicId,e.attributes.push(l)}}catch(i){r.e(i)}finally{r.f()}}}))},initMoneyWays:function(){var e=this;T("MONEY_WAY","/dic/getDics/").then((function(t){if(200==t.code){var a,r=Object(K["a"])(t.data);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.lable=n.dicValue,l.value=n.dicId,e.ways.push(l)}}catch(i){r.e(i)}finally{r.f()}}}))},initMoneyIsPays:function(){var e=this;T("MONEY_ISPAY","/dic/getDics/").then((function(t){if(200==t.code){var a,r=Object(K["a"])(t.data);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.lable=n.dicValue,l.value=n.dicId,e.isPays.push(l)}}catch(i){r.e(i)}finally{r.f()}}}))},initMonthOrYear:function(){var e=this;T("MONEY_MOY","/dic/getDics/").then((function(t){if(200==t.code){var a,r=Object(K["a"])(t.data);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.lable=n.dicValue,l.value=n.dicId,e.monthOrYearSeletorEl.push(l)}}catch(i){r.e(i)}finally{r.f()}}}))},initTableData:function(e){var t=this;T(e,"/tran/").then((function(e){if(200==e.code){console.log(e.data),t.tableData=[],t.page.total=e.data.total;var a,r=Object(K["a"])(e.data.records);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.id=n.id,l.name=n.name,l.amount=n.amount,l.date=n.date,l.attribute=n.attribute,l.attributeName=n.attributeName,l.way=n.way,l.wayName=n.wayName,l.isPay=n.isPay,l.isPayName=n.isPayName,t.tableData.push(l)}}catch(i){r.e(i)}finally{r.f()}}}))},handleCurrentChange:function(e){this.page.currentPage=e,this.handleSearch()},handleSizeChange:function(e){this.page.pageSize=e,this.handleSearch()},handleSearch:function(){var e=this;this.fullscreenLoading=!0;var t=this.page.currentPage+"/"+this.page.pageSize;q("post",this.search,"/tran/query/"+t).then((function(t){if(200==t.code){console.log(t.data),e.tableData=[],e.page.total=t.data.total;var a,r=Object(K["a"])(t.data.records);try{for(r.s();!(a=r.n()).done;){var n=a.value,l={};l.id=n.id,l.name=n.name,l.amount=n.amount,l.date=n.date,l.attribute=n.attribute,l.attributeName=n.attributeName,l.way=n.way,l.wayName=n.wayName,l.isPay=n.isPay,l.isPayName=n.isPayName,e.tableData.push(l)}}catch(i){r.e(i)}finally{r.f()}e.fullscreenLoading=!1}else e.$message({message:t.message,type:"error"}),e.fullscreenLoading=!1}))},openFullScreen:function(){var e=this;this.fullscreenLoading=!0,setTimeout((function(){e.fullscreenLoading=!1}),500)},submitForm:function(e){var t=this;this.$refs[e].clearValidate(),this.$refs[e].validate((function(e){if(e){t.ruleForm.date=new Date(t.ruleForm.date.toLocaleDateString()),t.fullscreenLoading=!0;var a="post";t.ruleForm.id&&(a="put"),q(a,t.ruleForm,"/tran/").then((function(e){200==e.code?(t.$message({message:e.data,type:"success"}),t.handleSearch(t.page.currentPage+"/"+t.page.pageSize),t.dialogInsertVisible=!1,t.fullscreenLoading=!1,t.refreshEchartData()):(t.$message({message:e.message,type:"error"}),t.fullscreenLoading=!1)}))}}))},cancelForm:function(e){this.dialogInsertVisible=!1,this.$refs[e].clearValidate()},resetForm:function(e){this.$refs[e].resetFields()},showInsertDialog:function(){this.ruleForm={name:"",amount:"",attribute:"",way:"",date:"",isPay:"",id:""},this.dialogInsertVisible=!0},initSumEchratData:function(){var e=this;return Object(J["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,T("","/echart/sum").then((function(t){if(200===t.code){e.sumEchartData=[];var a,r=t.data,n=Object(K["a"])(r);try{for(n.s();!(a=n.n()).done;){var l=a.value,i=[];i[0]=l.date,i[1]=parseFloat(l.amount).toFixed(2),e.sumEchartData.push(i)}}catch(o){n.e(o)}finally{n.f()}}else e.$message({message:t.data,type:"error"})}));case 2:case"end":return t.stop()}}),t)})))()},initAttrEchratData:function(){var e=this;return Object(J["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,T("","/echart/attr/"+e.echartMonOrYear).then((function(t){if(200===t.code){e.attrEchartData=[];var a,r=t.data,n=Object(K["a"])(r);try{for(n.s();!(a=n.n()).done;){var l=a.value;if(null!=l.attrName){var i={};i.value=parseFloat(l.amount).toFixed(2),i.name=l.attrName,e.attrEchartData.push(i)}}}catch(o){n.e(o)}finally{n.f()}console.log(e.attrEchartData),0===e.attrEchartData.length&&e.$message({message:"当前时间段无数据展示",type:"error"})}else e.$message({message:t.message,type:"error"})}));case 2:case"end":return t.stop()}}),t)})))()},initWayEchratData:function(){var e=this;return Object(J["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,T("","/echart/way/"+e.echartMonOrYear).then((function(t){if(200===t.code){e.wayEchartData=[];var a,r=t.data,n=Object(K["a"])(r);try{for(n.s();!(a=n.n()).done;){var l=a.value;if(null!=l.attrName){var i={};i.value=parseFloat(l.amount).toFixed(2),i.name=l.attrName,e.wayEchartData.push(i)}}}catch(o){n.e(o)}finally{n.f()}console.log(e.wayEchartData)}else e.$message({message:t.message,type:"error"})}));case 2:case"end":return t.stop()}}),t)})))()},initIsPayEchratData:function(){var e=this;return Object(J["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,T("","/echart/ispay/"+e.echartMonOrYear).then((function(t){if(200===t.code){e.isPayEchartData=[];var a,r=t.data,n=Object(K["a"])(r);try{for(n.s();!(a=n.n()).done;){var l=a.value;if(null!=l.attrName){var i={};i.value=parseFloat(l.amount).toFixed(2),i.name=l.attrName,e.isPayEchartData.push(i)}}}catch(o){n.e(o)}finally{n.f()}console.log(e.isPayEchartData)}else e.$message({message:t.message,type:"error"})}));case 2:case"end":return t.stop()}}),t)})))()},refreshEchartData:function(){this.fullscreenLoading=!0,this.initSumEchratData(),this.initAttrEchratData(),this.initWayEchratData(),this.initIsPayEchratData(),this.fullscreenLoading=!1},moyHandler:function(){0==this.monthOrYear?(this.monthOrYearForDatePlugin="month",this.moyFormat="yyyy-MM",this.echartMonOrYear=""):(this.monthOrYearForDatePlugin="year",this.moyFormat="yyyy",this.echartMonOrYear="")}},created:function(){this.initMonthOrYear(),this.initMoneyAttributes(),this.initMoneyWays(),this.initMoneyIsPays(),this.initTableData(this.page.currentPage+"/"+this.page.pageSize),this.changeLoadingStatus(),this.refreshEchartData()},mounted:function(){},data:function(){var e=function(e,t,a){console.log(e),/^[0-9]+([.]{1}[0-9]+){0,1}$/.test(t)?a():a(new Error("请输入正确的数字"))};return{title:"详情",loading:!0,dialogFormVisible:!1,dialogInsertVisible:!1,value:!0,fullscreenLoading:!1,echartMonOrYear:(new Date).getFullYear().toString(),sumEchartData:[],attrEchartData:[],wayEchartData:[],isPayEchartData:[],monthOrYear:"",monthOrYearSeletorEl:[],monthOrYearForDatePlugin:"",moyFormat:"yyyy",page:{pageSizes:[10,20,30,40],pageSize:10,currentPage:1,total:0},tableStyle:{display:"none",width:"1570px"},echartStyle:{width:"739px",height:"500px",marginLeft:"50px",display:""},searchStyle:{display:"none",marginLeft:"35px",marginBottom:"20px"},echartSearchStyle:{display:""},editForm:{name:"",amount:"",date:"",attribute:"",way:"",isPay:""},formLabelWidth:"120px",multipleSelection:[],search:{startDate:"",endDate:"",name:"",attribute:"",way:"",isPay:""},tableData:[],attributes:[],ways:[],isPays:[],ruleForm:{name:"",amount:"",attribute:"",way:"",date:"",isPay:"",id:""},rules:{name:[{required:!0,message:"请输入交易名称",trigger:"blur"}],amount:[{required:!0,validator:e,trigger:"blur"}],attribute:[{required:!0,message:"请选择交易性质",trigger:"blur"}],way:[{required:!0,message:"请选择交易途径",trigger:"blur"}],isPay:[{required:!0,message:"请选择支出/收入",trigger:"blur"}],date:[{type:"date",required:!0,message:"请选择交易日期",trigger:"blur"}]}}}},we=ve,xe=(a("078f"),Object(s["a"])(we,W,H,!1,null,"4bcf78fa",null)),Se=xe.exports,Fe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-card",{staticClass:"box-card",staticStyle:{width:"560px",height:"500px"}},[a("el-form",{ref:"ruleForm",staticStyle:{width:"500px",height:"500px"},attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px",size:"medium"}},[a("el-form-item",{attrs:{label:"交易名称",prop:"name"}},[a("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1),a("el-form-item",{attrs:{label:"发生金额",prop:"amount"}},[a("el-input",{model:{value:e.ruleForm.amount,callback:function(t){e.$set(e.ruleForm,"amount",t)},expression:"ruleForm.amount"}})],1),a("el-form-item",{attrs:{label:"交易日期",required:""}},[a("el-form-item",{attrs:{prop:"date"}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.ruleForm.date,callback:function(t){e.$set(e.ruleForm,"date",t)},expression:"ruleForm.date"}})],1)],1),a("el-form-item",{attrs:{label:"交易性质",prop:"attribute"}},[a("el-select",{staticStyle:{width:"400px"},attrs:{placeholder:"请选择性质"},model:{value:e.ruleForm.attribute,callback:function(t){e.$set(e.ruleForm,"attribute",t)},expression:"ruleForm.attribute"}},e._l(e.attributes,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"交易途径",prop:"way"}},[a("el-select",{staticStyle:{width:"400px"},attrs:{placeholder:"请选择途径"},model:{value:e.ruleForm.way,callback:function(t){e.$set(e.ruleForm,"way",t)},expression:"ruleForm.way"}},e._l(e.ways,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"支出/收入",prop:"isPay"}},[a("el-select",{staticStyle:{width:"400px"},attrs:{placeholder:"请选择支出/收入"},model:{value:e.ruleForm.isPay,callback:function(t){e.$set(e.ruleForm,"isPay",t)},expression:"ruleForm.isPay"}},e._l(e.isPays,(function(e){return a("el-option",{key:e.value,attrs:{label:e.lable,value:e.value}})})),1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("提交")]),a("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("重置")])],1)],1)],1)],1)},Ee=[],De={data:function(){return{attributes:[{lable:"餐饮费",value:0},{lable:"生活物品",value:1},{lable:"全款购物",value:2},{lable:"分期购物",value:3},{lable:"水电费",value:4},{lable:"交通费",value:5},{lable:"工资",value:6},{lable:"红包",value:7},{lable:"奖金",value:8}],ways:[{lable:"微信支付",value:0},{lable:"支付宝支付",value:1},{lable:"银行卡转账",value:2},{lable:"现金支付",value:3}],isPays:[{lable:"支出",value:0},{lable:"收入",value:1}],ruleForm:{name:"",amount:"",attribute:"",way:"",date:"",isPay:""},rules:{name:[{required:!0,message:"请输入交易名称",trigger:"blur"}],amount:[{required:!0,message:"请输入交易金额",trigger:"blur"}],attribute:[{required:!0,message:"请选择交易性质",trigger:"change"}],way:[{required:!0,message:"请选择交易途径",trigger:"change"}],isPay:[{required:!0,message:"请选择支出/收入",trigger:"change"}],date:[{type:"date",required:!0,message:"请选择交易日期",trigger:"change"}]}}},methods:{submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return console.log("error submit!!"),!1;t.$message({message:"后台接口暂未开放！",type:"error"})}))},resetForm:function(e){this.$refs[e].resetFields()}}},ke=De,Oe=Object(s["a"])(ke,Fe,Ee,!1,null,null,null),Pe=Oe.exports;r["default"].use(d["a"]);var $e=new d["a"]({routes:[{path:"/index",name:"首页",component:C,children:[{path:"/moneytable",component:Se},{path:"/moneyform",component:Pe}]},{path:"/login",name:"login",component:B}]}),_e=a("2f62");r["default"].use(_e["a"]);var Ce=new _e["a"].Store({state:{token:""},mutations:{setToken:function(e,t){e.token=t}},getters:{getToken:function(e){return console.log("当前token:"+e.token),e.token}}}),Ie=a("313e"),je=a.n(Ie);r["default"].config.productionTip=!1,r["default"].use(h.a),r["default"].prototype.$echarts=je.a,r["default"].prototype.$axios=M.a,$e.beforeEach((function(e,t,a){var r=!!window.sessionStorage.getItem("token");"/login"==e.path||r?a():a("/login")})),new r["default"]({router:$e,render:function(e){return e(u)},store:Ce}).$mount("#app")},"8f88":function(e,t,a){"use strict";a("f74c")},a7e3:function(e,t,a){},c4b6:function(e,t,a){"use strict";a("a7e3")},f74c:function(e,t,a){}});
//# sourceMappingURL=app.dc5b8ff1.js.map