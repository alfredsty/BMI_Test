# BMI_Test

# 구현 목록
## 메인 화면(activity_main.xml)
<img width="415" alt="image" src="https://user-images.githubusercontent.com/102028778/191989376-d241559d-8b9e-4ebc-93a8-9e2b32192b51.png">

## 결과 화면(activity_result.xml)
<img width="335" alt="image" src="https://user-images.githubusercontent.com/102028778/191989412-a10ce3fc-988d-4c1e-98d1-4444e4b88eac.png">

# CODE REVIEW

## MainActivity
```kotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // ?(물음표)는 Null이 가능하다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val resultButton: Button = findViewById(R.id.resultButton)

        resultButton.setOnClickListener{
            if(nameEditText == null && weightEditText == null && weightEditText == null){
                val intent = Intent(this, ResultActivity::class.java)   // Intent는 액티비티 이동
                intent.putExtra("nameEditText",nameEditText.text.toString())
                intent.putExtra("height",heightEditText.text.toString().toInt())
                intent.putExtra("weight",weightEditText.text.toString().toInt())
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "모두 입력했는지 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

### findviewbyid란?
```kotlin
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val resultButton: Button = findViewById(R.id.resultButton)

```
findviewbyid는 ID로 부터 대응되는 뷰객체를 찾는 메소드이다. findViewById를 사용할 때 ID가 지정하는 뷰의 타입과 캐스팅 타입과 일치해야 한다
요즘에는 ViewBinding을 써 코드를 간략하게 짤 수 있다.

### asd

```kotlin
  resultButton.setOnClickListener{
            if(nameEditText == null && weightEditText == null && weightEditText == null){
                val intent = Intent(this, ResultActivity::class.java)   // Intent는 액티비티 이동
                intent.putExtra("nameEditText",nameEditText.text.toString())
                intent.putExtra("height",heightEditText.text.toString().toInt())
                intent.putExtra("weight",weightEditText.text.toString().toInt())
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "모두 입력했는지 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

```



## ResultActivity

```kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("nameEditText")
        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val bmi = weight / (height * 0.01).pow(2)
        val resultText = when {
            bmi >= 30 -> "비만"
            bmi >= 25 -> "과체중"
            bmi >= 20 -> "정상"
            else -> "저체중"
        }

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        resultTextView.text = "${name}님의 BMI는 ${bmi}입니다. 결과는 ${resultText}입니다."


    }
}

```




