package com.lapin.otakushopukraine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
   private var loginAction:String? = "Вхід"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setActionTexts(loginAction!!,"Увійти","У мене немає облікового запису")
    }
    fun changeAction(view: View?)
    {
        if(loginAction!! ==="Вхід"){
            loginAction = "Реєстрація"
            setActionTexts(loginAction!!,"Зареєструватись","У мене вже є обліковий запис")
        }
        else if (loginAction!! ==="Реєстрація")
        {
            loginAction = "Вхід"
            setActionTexts(loginAction!!,"Увійти","У мене немає облікового запису")
        }
    }
    private fun setActionTexts(newTitle:String,newSubmitText:String,newChangeActionText:String)
    {
        title = newTitle
        findViewById<Button>(R.id.submitLoginButton).text = newSubmitText
        findViewById<TextView>(R.id.changeActionText).text = newChangeActionText

    }
}
