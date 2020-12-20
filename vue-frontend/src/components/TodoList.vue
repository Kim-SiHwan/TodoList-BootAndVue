<template>
  <ul>
    <li v-for="(list,index) in probsdata" :key="index">
      {{list.item}}, {{index}}
    </li>
  </ul>

</template>

<script>
export default {
  name: "TodoList",
  props: ['probsdata'],
  data(){
    return{
      list:''
    }
  }
}
</script>

<style scoped>

</style>