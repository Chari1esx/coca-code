<script setup lang="ts">
import Taro from "@tarojs/taro"
import quizResult from '../../data/quizResult.json'
import quiz from '../../data/quiz.json'
import {analyzeMbtiResult} from '../../utils/AnalyzeResult'
import './ResultView.scss'

const answerList = Taro.getStorageSync('answerList')
if (!answerList || answerList.length < 1) {
  Taro.showToast({
    title: 'error',
    icon: 'error',
    duration: 2000,
  })
}
const result = analyzeMbtiResult(answerList, quiz, quizResult)

</script>

<template>
  <view class="result-view">
    <view class='at-article__h1 title'>{{ result.resultName }}</view>
    <view class='at-article__h2 sub-title'>{{ result.resultDesc }}</view>
    <AtButton type='primary' circle class="btn" @click="() => {
      Taro.reLaunch({
        url: '/pages/index/IndexView',
      })
    }">
      返回主页
    </AtButton>
    <image src="../../assets/bg.png" class="bg"/>
  </view>
</template>
