/**
 * 获取 MBTI
 */
export function analyzeMbtiResult(answerList: string[], questions: any, question_results: any) {
  const optionCount = {}

  for (let i = 0; i < questions.length && i < answerList.length; i++) {
    const question = questions[i]
    const answer = answerList[i]
    for (const option of question.options) {
      if (option.key === answer) {
        const result = option.result
        if (!optionCount[result]) {
          optionCount[result] = 0
        }
        optionCount[result]++
      }
    }
  }

  let maxScore = -1
  let maxScoreResult = null
  for (const result of question_results) {
    const score = result.resultProp.reduce((count: any, prop: any) => {
      return count + (optionCount[prop] || 0)
    }, 0)
    if (score > maxScore) {
      maxScore = score
      maxScoreResult = result
    } else if (score === maxScore && maxScoreResult === null) {
      maxScoreResult = result
    }
  }
  return maxScoreResult
}
