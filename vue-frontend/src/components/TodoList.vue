<template>
  <ul>
    <li v-for="(list,index) in probsdata" :key="index">
      {{list.item}}
      <button @click="removeItem(list.itemId,index)">제거</button>
    </li>
  </ul>

</template>

<script>
export default {
  name: "TodoList",
  props: ['probsdata'],
  methods: {
    removeItem(itemId,index){
      this.$emit('removeItem',itemId,index);
    }
  }
}
</script>

<style scoped>

</style>