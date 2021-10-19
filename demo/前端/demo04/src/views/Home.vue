<template>
  <div class="home">
      <div>
          <el-input placeholder="请输入姓名进行搜索，可以直接回车搜索..."
                    @clear="initAllDept"
                    prefix-icon="el-icon-search"
                    style="width: 350px;margin-right: 10px"
                    clearable
                    :clear="initAllDept"
                    v-model="keywords"
                    @keydown.enter.native="initAllDept"
          >
          </el-input>
          <el-button icon="el-icon-search" size="small" type="primary" @click="initAllDept" >
              搜索
          </el-button>
          <div style="display: flex;justify-content: space-between">
              <el-button type="primary" icon="el-icon-plus" size="small" @click="addDept">添加联系人信息</el-button>
          </div>
      </div>
      <!--表格开始-->
      <div style="margin-top: 8px">
      <el-table
              :data="depts"
              border
              style="width: 100%">
          <el-table-column
                  prop="deptno"
                  label="电话"
                  width="180">
          </el-table-column>
          <el-table-column
                  prop="dname"
                  label="姓名"
                  width="180">
          </el-table-column>
          <el-table-column
                  prop="loc"
                  label="地址">
          </el-table-column>
          <el-table-column label="操作">
              <template slot-scope="scope">
                  <el-button size="small" @click="updateDept(scope.row)">编辑</el-button>
                  <el-button size="small" type="danger" @click="deleteDept(scope.row)">删除</el-button>
              </template>
          </el-table-column>
      </el-table>
          <div style="display:flex;justify-content:flex-end ">
              <el-pagination
                      background
                      layout="sizes, prev, pager, next, jumper, ->, total, slot"
                      @current-change="currentChange"
                      @size-change="sizeChange"
                      :total="total">
              </el-pagination>
          </div>
      </div>
      <!--表格结束-->
      <!--弹出层开始-->
      <el-dialog
              :title="dialogTitle"
              :visible.sync="dialogVisible"
              width="50%">
          <el-form ref="form" :model="dept" label-width="80px">
              <el-form-item label="姓名">
                  <el-input v-model="dept.dname"></el-input>
              </el-form-item>
              <el-form-item label="地址">
                  <el-input v-model="dept.loc"></el-input>
              </el-form-item>
              <el-form-item label="电话">
              <el-input v-model="dept.deptno"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="onSubmit">提交</el-button>
              </el-form-item>
          </el-form>
      </el-dialog>
      <!--弹出层结束-->
  </div>


</template>

<script>
// 导入封装的请求
import {getRequest} from "../uitls/api";
import {postRequest} from "../uitls/api";
import {putRequest} from "../uitls/api";
import {deleteRequest} from "../uitls/api";

export default {
  name: 'Home',
    data() {
        return {
            keywords:'',
            depts:[],//显示数据
            total:0,
            dialogTitle:"添加",
            dialogVisible:false,
            size:10,//分页每页10条数据
            page:1,//从第一页开始
            dept:{
                dname:'',
                loc:''
             }
        }
    },
    methods:{
       //分页
        currentChange(currentChange){
            this.page=currentChange
            this.initAllDept()
        },
        sizeChange(sizeChange){
            this.size=sizeChange
            this.initAllDept()
        },
        /**
         * /dept  请求地址
         */
        initAllDept(){
            //调用get请求
          getRequest("/dept/?keywords="+this.keywords+"&page="+this.page+"&size="+this.size).then(res=>{
              if(res){
                  this.depts=res.data
                  this.total=res.total
              }
          })
      },
        onSubmit(){
          if(this.dept.deptno){//this.dept.deptno有值就是修改，否则就是删除

              //修改
              //调用put请求
              putRequest("/dept/",this.dept).then(res=>{
                  if(res){
                      this. dialogVisible=false
                      //修改成功刷新数据
                      this.initAllDept()
                      //清空弹出层数据
                      this.dept.dname='';
                      this.dept.loc='';
                  }
              })
          }else{
              //添加
              //调用post请求
              postRequest("/dept/",this.dept).then(res=>{
                  if(res){
                      this. dialogVisible=false
                      //添加成功刷新数据
                      this.initAllDept()
                      //清空弹出层数据
                      this.dept.dname='';
                      this.dept.loc='';
                  }
              })
          }
        },
        addDept(){
            //打开弹出层
            this.dialogVisible=true
            //改变弹出成title
            this.dialogTitle="添加"
            //清空弹出层数据
            this.dept.dname='';
            this.dept.loc='';
        },
        updateDept(data){
            //填充数据  数据回显
            this.dept=data
            //打开弹出层
            this.dialogVisible=true
            //改变弹出成title
            this.dialogTitle="修改"
        },
        deleteDept(data){
            this.$confirm('此操作将永久删除【' + data.dname + '】, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                //调用delete请求
                deleteRequest("/dept/"+data.deptno).then(res=>{
                    if(res){
                        this.initAllDept()
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }
    },
    //初始化数据
    mounted(){
      this.initAllDept();
    }

}
</script>
<style>
    .home{
        width: 800px;
        margin: 20px auto;
    }
</style>
