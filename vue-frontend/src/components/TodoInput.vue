<template>
  <div>
    <input type="text" v-model="item" v-on:keyup.enter="addItem"
    placeholder="할 일을 입력하세요!">
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

<style scoped>

</style>