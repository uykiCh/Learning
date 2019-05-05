package architecture

fun main(args: Array<String>) {
    val mainAct = MainActivity()
    mainAct.setMessage("str")
}

class MainActivity : InteractionsMainActivity {

    private val mvpTabletController = MVPTabletController(this)

    fun setMessage(str: String){

        mvpTabletController.setMessage(str)

    }
}

class MVPTabletController(private val interactionsMainActivity: InteractionsMainActivity) {

    private val tabletPresenter = TabletPresenter(this)

    fun setMessage(str:String){

        tabletPresenter.setTablePresenter()
        tabletPresenter.setMessage(str)

    }

}

class TabletPresenter(private val tableController: MVPTabletController) {

    val messageListPresenter = MessageListPresenter()

    fun setMessage(str:String){

        messageListPresenter.setMessage(str)

    }

    fun completeSetMessage(){

        print("complete")

    }

    fun setTablePresenter() {

        messageListPresenter.fragment.setTablePresenter(this)

    }

}

class MessageListPresenter() {

    fun setMessage(str:String){

        fragment.setMessage(str)

    }

    val fragment = FragmentMessages()

}

class FragmentMessages: InteractionsMessageListPresenter, InteractionsTabletPresenter {

    override fun setTablePresenter(tabletPresenter:TabletPresenter) {
        this.tabletPresenter = tabletPresenter
    }

    private lateinit var tabletPresenter:TabletPresenter

    fun setMessage(str: String){
        print(str)
        tabletPresenter.completeSetMessage()
    }

}

interface InteractionsMainActivity{

}
interface InteractionsMessageListPresenter {



}
interface InteractionsTabletPresenter{
    fun setTablePresenter(tabletPresenter:TabletPresenter)
}