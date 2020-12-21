<template>
  <div class="inputBox">
    <input type="text" v-model="item" v-on:keyup.enter="addItem"
    placeholder="할 일을 입력하세요!">
    <span class="addContainer" @click="addItem">
      <i class="addBtn fas fa-plus" aria-hidden="true"></i>
    </span>
  </div>
</template>

<script>

export default {
  name: "TodoInput",
  data(){
    return{
      item :'',
      form :''
    }
  },
  methods :{
    addItem(){
      this.form = {
        item : this.item
      };
      if(this.item.length!=0){
        console.log(this.form);
        this.$emit('addItem',this.form);
        this.clearItem();
      }
    },
    clearItem(){
      this.item='';
    }
  }
}
</script>

<style>
input:focus{
  outline:none;
}
.inputBox{
  background-color: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
  width: 500px; margin-left: 700px;
}
.inputBox input{
  border-style:none;
  font-size:0.9rem;
}
.addContainer{
  float:right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn{
  color:white;
}

</style>