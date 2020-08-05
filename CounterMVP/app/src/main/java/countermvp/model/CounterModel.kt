package countermvp.model

import countermvp.contract.MainScreenContract

class CounterModel : MainScreenContract.Model {
    private var counter = 0

    override fun modelIncrementCounter() {
        ++counter
    }

    override fun modelDecrementCounter() {
       --counter
    }

    override fun modelGetCounterValue() : Int {
        return counter
    }
}