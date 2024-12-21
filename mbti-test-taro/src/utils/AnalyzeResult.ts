/**
 * 获取 MBTI
 */
export function analyzeMbtiResult(answerList: string[], questions: any, question_results: any) {
  const optionCount = {};

  for (const question of questions) {
    for (const answer of answerList) {
      for (const option of question.options) {
        if (option.key === answer) {
          const result = option.result;
          if (!optionCount[result]) {
            optionCount[result] = 0;
          }
          optionCount[result]++;
        }
      }
    }
  }
  let maxScore = 0;
  let maxScoreResult = question_results[0];
  for (const result of question_results) {
    const score = result.resultProp.reduce((count: any, prop: any) => {
      return count + (optionCount[prop] || 0);
    }, 0);
    if (score > maxScore) {
      maxScore = score;
      maxScoreResult = result;
    }
  }
  return maxScoreResult;
}
