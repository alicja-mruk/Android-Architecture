package countermvp.presenter
import countermvp.contract.MainScreenContract
import countermvp.model.CounterModel

class CounterPresenter() : MainScreenContract.Presenter {
    private var view: MainScreenContract.View? = null
    private val model: CounterModel = CounterModel()

    override fun attachView(_view: MainScreenContract.View) {
        view = _view
    }

    override fun detachView() {
        view = null
    }

    override fun getCounterValue(): Int {
        return model.modelGetCounterValue()
    }

    override fun incrementCounter() {
        model.modelIncrementCounter()
        view?.updateView()
    }

    override fun decrementCounter() {
        model.modelDecrementCounter()
        view?.updateView()
    }
}