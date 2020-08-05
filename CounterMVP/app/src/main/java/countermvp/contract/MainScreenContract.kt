package countermvp.contract
interface MainScreenContract {
    interface View{
        fun initView()
        fun setOnClickListeners()
        fun updateView()
    }

    interface Presenter{
        fun attachView(_view :View)
        fun detachView()
        fun getCounterValue() : Int
        fun incrementCounter()
        fun decrementCounter()
    }

    interface Model{
        fun modelIncrementCounter()
        fun modelDecrementCounter()
        fun modelGetCounterValue() : Int
    }
}