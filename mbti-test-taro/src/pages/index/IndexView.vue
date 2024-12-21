<script setup lang="ts">
import './IndexView.scss'
import Taro from "@tarojs/taro"
</script>

<template>
  <view class="index-view">
    <view class='at-article__h1 title'>MBTI 测试</view>
    <AtButton type='primary' circle class="btn" @click="() => {
      Taro.navigateTo({
        url: '/pages/quiz/QuizView',
      })
    }">
      开始测试
    </AtButton>
    <image src="../../assets/bg.png" class="bg"/>
  </view>
</template>
