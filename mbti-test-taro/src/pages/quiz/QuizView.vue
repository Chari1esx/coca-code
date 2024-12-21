<script setup lang="ts">
import quiz from '../../data/quiz.json'
import Taro from "@tarojs/taro";
import {computed, ref} from "vue";
import './QuizView.scss'

/**
 * 当前题号
 */
const current = ref<number>(0)

/**
 * 当前题目
 */
const currentQuestion = computed(() => quiz[current.value])

/**
 * 当前题目选项
 */
const questionOptions = computed(() => {
  return currentQuestion.value.options.map(option => ({
    label: `${option.key}. ${option.value}`,
    value: option.key,
  }))
})

/**
 * 当前题目答案
 */
const currentAnswer = ref<string>()

/**
 * 题目答案列表
 */
const answerList = ref<string[]>([])

/**
 * 下一题
 */
const nextQuestion = () => {
  currentAnswer.value = ''
  current.value++
}

/**
 * 上一题
 */
const prevQuestion = () => {
  currentAnswer.value = ''
  current.value--
}

/**
 * 点击选项
 */
const handleOptionClick = (value: any) => {
  currentAnswer.value = value;
  if (current.value < quiz.length) {
    answerList.value[current.value] = value;
  }
}

/**
 * 提交答案
 */
const submitAnswerList = () => {
  Taro.setStorageSync('answerList', answerList.value)
  Taro.navigateTo({
    url: '/pages/result/ResultView',
  })
}
</script>

<template>
  <view class="quiz-view">
    <view class='at-article__h2 title'>
      {{ current + 1 }}、{{ currentQuestion.title }}
    </view>
    <view class='options-wrapper'>
      <at-radio
        :options="questionOptions"
        :value="currentAnswer"
        @click="handleOptionClick"
      />
    </view>
    <AtButton
      v-if="current < quiz.length - 1"
      type="primary"
      circle
      class="control-btn"
      @click="nextQuestion"
      :disabled="!currentAnswer"
    >
      下一题
    </AtButton>
    <AtButton
      v-if="current == quiz.length - 1"
      type='primary'
      circle
      class="control-btn"
      @click="submitAnswerList"
      :disabled="!currentAnswer"
    >
      查看结果
    </AtButton>
    <AtButton
      v-if="current > 0"
      circle
      class="control-btn"
      @click="prevQuestion">
      上一题
    </AtButton>
  </view>
</template>
