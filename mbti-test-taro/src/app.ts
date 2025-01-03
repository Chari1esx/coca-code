import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createUI } from 'taro-ui-vue3'

import './app.scss'
import 'taro-ui-vue3/dist/style/index.scss'

const App = createApp({
  onShow(options: any) {
    console.log('onShow: ' ,options)
  },
  // 入口组件不需要实现 render 方法，即使实现了也会被 taro 所覆盖
})

App.use(createPinia())
App.use(createUI())

export default App
