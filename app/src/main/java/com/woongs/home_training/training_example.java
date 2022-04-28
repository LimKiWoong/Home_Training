package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class training_example extends AppCompatActivity {

    TextView training_name;
    TextView training_example_text;
    Button example_ok;
    GlobalVariables globalVariables = new GlobalVariables();
    Handler handler;
    int tag,getcount;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_example);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        training_name = (TextView) findViewById(R.id.training_name);
        training_example_text = (TextView) findViewById(R.id.training_example_text);
        example_ok = (Button) findViewById(R.id.example_ok);

        intent = getIntent();
        int pos = intent.getIntExtra("pos",0);
        tag = intent.getIntExtra("tag",1);
        getcount = intent.getIntExtra("count",1);

        handler = new Handler();

        switch (globalVariables.getImage()){
            case 1:
                training_name.setText("플랭크");
                training_example_text.setText("1. 엎드린 자세에서 팔뚝으로 중심을 잡고 다리는 약간 벌린 상태로 일자를 유지한다. 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n" +
                        "2. 팔꿈치와 어깨는 일자를 유지한다. \n\n" +
                        "3. 복부에 힘을 주고 몸을 앞으로 들어 올린다. 수축을 몇 초간 유지한다. 턱은 약간 잡아당긴다. 운동을 실시하는 동안 복근을 계속 수축하게 한다. " +
                        "의식적으로 힘을 주면서 복부의 모든 근육에 대해 집중하면서 운동하는 것이 매우 중요하다. 그것과 동시에 둔부에 힘을 주고 발가락을 바닥에 지지대 삼아 " +
                        "뒤꿈치를 밀어 주면서 하체 전체를 뒤로 밀어내는 감각으로 뻗으면 엉덩이도 자연스럽게 내려오고 어깨와 팔에 하중이 경감된다. 고개는 너무 떨구는 일이 없도록 한다. \n\n" +
                        "4. 이 자세를 최소 15초 동안 유지한다.");
                break;
            case 2:
                training_name.setText("크런치");
                training_example_text.setText("1. 바닥에 누워서 다리를 고정시키고 시선은 자연스럽게 몸이 바라보는 방향과 같도록 한다.\n\n" +
                        "2. 골반을 살짝 후반경사시켜 허리와 바닥 사이의 공간이 없도록 한다.\n\n" +
                        "3. 시선이 천장을 향하면서 복근을 쥐어짜는 힘으로 상반신을 적당히 든다. 이 때 머리를 과도하게 당기지 않는다.\n\n" +
                        "4. 다시 2번의 자세로 돌아온다.\n\n" +
                        "5 .1 ~ 4 번을 반복한다.");
                break;
            case 3:
                training_name.setText("마운틴클라이머");
                training_example_text.setText("1. 팔을 가슴아래를받치고 지면과 수직으로 엎드려뻗쳐 자세를 유지한다.\n\n" +
                        "2. 허리가 아래로 내려가지않도록 복부에 긴장감을 유지해주고 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n" +
                        "3. 한쪽 무릎을 가슴까지 오도록 당겨준다.\n\n" +
                        "4. 원위치 후 반대쪽 무릎을 당겨준다.\n\n" +
                        "5. 다리를 바꿔가며 최대한빠르게 반복한다.");
                break;
            case 4:
                training_name.setText("바이시클메뉴버");
                training_example_text.setText("1. 누운 자세에서 양손을 머리 뒤에 또는 귀옆에 둔다.\n\n" +
                        "2. 양다리를 살짝 들어 올리고 자전거 페달을 밟듯이 무릎을 번갈아 가면서 천천히 가슴 쪽으로 굽혔다가 편다. 이때 아래에 있는 다리는 바닥에 닿지 않을 정도로 살짝 띄운다.\n\n" +
                        "3. 2번 자세에 익숙해졌다면 상체를 들어 올리고 오른쪽 무릎을 당기면서 왼쪽 팔꿈치가 오른쪽 무릎에 닿을 정도로 허리를 살짝 튼다. 이때 왼쪽 다리는 들어 올린 상태에서 편다.\n\n" +
                        "4. 서서히 오른쪽 다리를 펴면서 왼쪽 무릎을 당기고, 오른쪽 팔꿈치가 왼쪽 무릎에 닿을 정도로 상체를 들어 허리를 살짝 튼다.\n\n" +
                        "5. 3~4번 동작을 천천히 반복한다.");
                break;
            case 5:
                training_name.setText("팔굽혀펴기");
                training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                        "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                        "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                break;
            case 6:
                training_name.setText("싱글레그푸쉬업");
                training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 어깨와 일직선이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                        "2. 한발을 곧게 들어올린 상태로 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. " +
                        "균형을 잡으며 몸 전체의 정렬을 유지한다.(목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n"+
                        "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                break;
            case 7:
                training_name.setText("인클라인푸쉬업");
                training_example_text.setText("1. 양손을 어깨너비보다 약간 벌리고 높은 곳에 올려 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                        "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                        "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                break;
            case 8:
                training_name.setText("디클라인푸쉬업");
                training_example_text.setText("양발은 높은 곳에 올리고 양손은 어깨너비보다 약간 벌려 몸은 일자를 유지한다.\n\n" +
                        "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                        "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                break;
            case 9:
                training_name.setText("라잉익스텐션");
                training_example_text.setText("1. 벤치에 누운 뒤 하체는 땅을 지지하고 허리는 아치형으로 몸을 고정한다.\n\n" +
                        "2. 덤벨을 일직선으로 든 뒤 머리쪽으로 천천히 기울인다.\n\n" +
                        "3. 덤벨을 들어올려 삼두근을 짜준다는 느낌으로 팔을 펴준다.\n\n" +
                        "4. 덤벨을 들고 내릴때 팔꿈치를 너무 벌어지지도 모르지도 않은 상태에서 팔꿈치를 고정하여 진행한다.");
                break;
            case 10:
                training_name.setText("킥백");
                training_example_text.setText("1. 벤치 위에 한쪽 팔다리를 올려놓고 허리를 굽히고 등을 곧게 편다.\n\n" +
                        "2. 아령을 잡은 손의 팔꿈치를 몸통옆에 고정시킨다.\n\n" +
                        "3. 천천히 팔을 몸과 같은 직선으로 쭉 뻗는다. (팔꿈치를 고정시킨다.)\n\n");
                break;
            case 11:
                training_name.setText("딥스");
                training_example_text.setText("1. 벤치의자를 몸 뒤에 놓고 양팔을 어깨너비 간격으로 벌리고 펴준다. 상체는 꼿꼿히 펴주고 양발을 붙이고 발 뒷꿈치 부분만 바닥에 닿는다.\n\n" +
                        "2. 팔을 굽혀서 수직으로 내려간다. 엉덩이가 바닥에 닿지않도록한다. 여전히 발 뒷꿈치 부분만 바닥에 닿은상태 유지\n\n" +
                        "3. 오로지 팔 힘으로 몸을 위로 올려준다.");
                break;
            case 12:
                training_name.setText("덤벨컬");
                training_example_text.setText("1. 어깨를 내리고 몸 옆에 덤벨을 위치시킨다.\n\n" +
                        "2. 몸통,어깨가 고정된 채로 그대로 팔만 올린다. 손목과 손바닥이 위를 보는 느낌으로 유지한다.");
                break;
            case 13:
                training_name.setText("스쿼트");
                training_example_text.setText("1. 양발을 어깨너비로 벌리고 양손은 깍지를끼거나 앞으로 뻗는다.\n\n" +
                        "2. 양발 끝은 바깥쪽으로 약간 벌려준다.\n\n" +
                        "3. 상체를 꼿꼿히 유지하면서 엉덩이를 뒤로 빼준다.\n\n" +
                        "4. 동시에 천천히 무릎을 굽히면서 허벅지가 바닥과 평행이 될때까지 내려간다.");
                break;
            case 14:
                training_name.setText("런지");
                training_example_text.setText("1. 두 다리를 골반넓이 정도로 벌린다.\n\n" +
                        "2. 허리를 피며 한 발을 앞으로 내딛는다\n\n" +
                        "3. 내딛은 무릎을 직각으로 굽히고 반대쪽 무릎이 바닥에 닿기 직전까지 내려간다..\n\n" +
                        "4. 내딛은 다리로 밀어내며 1번으로 돌아가서 다시 반대쪽도 동일하게 시행한다.");
                break;
            case 15:
                training_name.setText("측면운동");
                training_example_text.setText("1. 발을 모으고 등을 곧게 편다 손은 앞으로 모은다.\n\n" +
                        "2. 다리 한쪽을 옆으로 뻗는다 반대편 다리의 무릎은 약간 구부린다.\n\n" +
                        "3. 스쿼트 자세처럼 엉덩이를 뒤로 빼주면서 자세를 낮춘다.");
                break;
            case 16:
                training_name.setText("사이드레그레이즈");
                training_example_text.setText("1. 옆으로 누운 후 다리를 곧게 펴준다.\n\n" +
                        "2. 한 손으로 머리를 받친 후 나머지 손은 바닥을 짚는다.\n\n" +
                        "3. 위쪽 다리를 들어올리고 내린다.");
                break;
            case 100:
                switch (pos){
                    case 0:
                        training_name.setText("팔벌려뛰기");
                        training_example_text.setText("1. 발을 어깨너비로 벌리고 팔을 몸통 옆에 둡니다.\n\n" +
                                "2. 점프하면서 다리를 어깨너비보다 넓게 벌리고 팔을 벌려 머리 위로 올려줍니다\n\n"+
                                "3. 다시 점프하여 다리를 모으고 팔을 내립니다.");
                        break;
                    case 1:
                        training_name.setText("마운틴 클라이머");
                        training_example_text.setText("1. 팔을 가슴아래를받치고 지면과 수직으로 엎드려뻗쳐 자세를 유지한다.\n\n"+
                                "2. 허리가 아래로 내려가지않도록 복부에 긴장감을 유지해주고 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n"+
                                "3. 한쪽 무릎을 가슴까지 오도록 당겨준다.\n\n"+
                                "4. 원위치 후 반대쪽 무릎을 당겨준다.\n\n"+
                                "5. 다리를 바꿔가며 최대한빠르게 반복한다.");
                        break;
                    case 2:
                        training_name.setText("플랭크");
                        training_example_text.setText("1. 엎드린 자세에서 팔뚝으로 중심을 잡고 다리는 약간 벌린 상태로 일자를 유지한다. 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n" +
                                "2. 팔꿈치와 어깨는 일자를 유지한다. \n\n" +
                                "3. 복부에 힘을 주고 몸을 앞으로 들어 올린다. 수축을 몇 초간 유지한다. 턱은 약간 잡아당긴다. 운동을 실시하는 동안 복근을 계속 수축하게 한다. " +
                                "의식적으로 힘을 주면서 복부의 모든 근육에 대해 집중하면서 운동하는 것이 매우 중요하다. 그것과 동시에 둔부에 힘을 주고 발가락을 바닥에 지지대 삼아 " +
                                "뒤꿈치를 밀어 주면서 하체 전체를 뒤로 밀어내는 감각으로 뻗으면 엉덩이도 자연스럽게 내려오고 어깨와 팔에 하중이 경감된다. 고개는 너무 떨구는 일이 없도록 한다. \n\n" +
                                "4. 이 자세를 최소 15초 동안 유지한다.");
                        break;
                    case 3:
                        training_name.setText("크런치");
                        training_example_text.setText("1. 바닥에 누워서 다리를 고정시키고 시선은 자연스럽게 몸이 바라보는 방향과 같도록 한다.\n\n" +
                                "2. 골반을 살짝 후반경사시켜 허리와 바닥 사이의 공간이 없도록 한다.\n\n" +
                                "3. 시선이 천장을 향하면서 복근을 쥐어짜는 힘으로 상반신을 적당히 든다. 이 때 머리를 과도하게 당기지 않는다.\n\n" +
                                "4. 다시 2번의 자세로 돌아온다.\n\n" +
                                "5 .1 ~ 4 번을 반복한다.");
                        break;
                    case 4:
                        training_name.setText("무릎대고 팔굽혀펴기");
                        training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 무릎을 바닥에 대고(쿠션이나매트) 발은 땅에 닿지 않도록한다.\n\n"+
                                "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 5:
                        training_name.setText("인클라인푸쉬업");
                        training_example_text.setText("1. 양손을 어깨너비보다 약간 벌리고 높은 곳에 올려 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 6:
                        training_name.setText("가슴모아 올리기");
                        training_example_text.setText("1. 가슴앞에 두손을합쳐 합장 자세를 취한다.\n\n"+
                                "2. 천천히 손을 위로 올린다. 양쪽 팔꿈치가 서로 닿을수 있을때까지 올린다.\n\n" +
                                "3. 일정시간 후 다시 1번 자세를 취한다.");
                        break;
                    case 7:
                        training_name.setText("스쿼트");
                        training_example_text.setText("1. 양발을 어깨너비로 벌리고 양손은 깍지를끼거나 앞으로 뻗는다.\n\n" +
                                "2. 양발 끝은 바깥쪽으로 약간 벌려준다.\n\n" +
                                "3. 상체를 꼿꼿히 유지하면서 엉덩이를 뒤로 빼준다.\n\n" +
                                "4. 동시에 천천히 무릎을 굽히면서 허벅지가 바닥과 평행이 될때까지 내려간다.");
                        break;
                    case 8:
                        training_name.setText("런지");
                        training_example_text.setText("1. 두 다리를 골반넓이 정도로 벌린다.\n\n" +
                                "2. 허리를 피며 한 발을 앞으로 내딛는다\n\n" +
                                "3. 내딛은 무릎을 직각으로 굽히고 반대쪽 무릎이 바닥에 닿기 직전까지 내려간다..\n\n" +
                                "4. 내딛은 다리로 밀어내며 1번으로 돌아가서 다시 반대쪽도 동일하게 시행한다.");
                        break;
                    case 9:
                        training_name.setText("마무리");
                        training_example_text.setText("1. 양손을 어깨너비, 무릎은 골반 너비로 벌린 자세로 엎드린 후 허리는 바닥과 수평을 이루게한다.\n\n" +
                                "2. 턱을 안쪽으로 당기고 등을 말아서 위로 들어올린다. 숨을 천천히 내쉰다.\n\n"+
                                "3. 손과 무릎은 고정한 채 양팔을 앞으로 쭉 뻗으며 엎드려 앉는다.\n\n"+
                                "4. 몸을 최대한 바닥에 붙여 늘어뜨린 후 편안하게 호흡한다.");
                        break;
                }
                break;



            case 101:
                switch (pos){
                    case 0:
                        training_name.setText("팔벌려뛰기");
                        training_example_text.setText("1. 발을 어깨너비로 벌리고 팔을 몸통 옆에 둡니다.\n\n" +
                                "2. 점프하면서 다리를 어깨너비보다 넓게 벌리고 팔을 벌려 머리 위로 올려줍니다\n\n"+
                                "3. 다시 점프하여 다리를 모으고 팔을 내립니다.");
                        break;
                    case 1:
                        training_name.setText("바이시클메뉴버");
                        training_example_text.setText("1. 누운 자세에서 양손을 머리 뒤에 또는 귀옆에 둔다.\n\n" +
                                "2. 양다리를 살짝 들어 올리고 자전거 페달을 밟듯이 무릎을 번갈아 가면서 천천히 가슴 쪽으로 굽혔다가 편다. 이때 아래에 있는 다리는 바닥에 닿지 않을 정도로 살짝 띄운다.\n\n" +
                                "3. 2번 자세에 익숙해졌다면 상체를 들어 올리고 오른쪽 무릎을 당기면서 왼쪽 팔꿈치가 오른쪽 무릎에 닿을 정도로 허리를 살짝 튼다. 이때 왼쪽 다리는 들어 올린 상태에서 편다.\n\n" +
                                "4. 서서히 오른쪽 다리를 펴면서 왼쪽 무릎을 당기고, 오른쪽 팔꿈치가 왼쪽 무릎에 닿을 정도로 상체를 들어 허리를 살짝 튼다.\n\n" +
                                "5. 3~4번 동작을 천천히 반복한다.");
                        break;
                    case 2:
                        training_name.setText("마운틴 클라이머");
                        training_example_text.setText("1. 팔을 가슴아래를받치고 지면과 수직으로 엎드려뻗쳐 자세를 유지한다.\n\n"+
                                "2. 허리가 아래로 내려가지않도록 복부에 긴장감을 유지해주고 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n"+
                                "3. 한쪽 무릎을 가슴까지 오도록 당겨준다.\n\n"+
                                "4. 원위치 후 반대쪽 무릎을 당겨준다.\n\n"+
                                "5. 다리를 바꿔가며 최대한빠르게 반복한다.");
                        break;
                    case 3:
                        training_name.setText("플랭크");
                        training_example_text.setText("1. 엎드린 자세에서 팔뚝으로 중심을 잡고 다리는 약간 벌린 상태로 일자를 유지한다. 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n" +
                                "2. 팔꿈치와 어깨는 일자를 유지한다. \n\n" +
                                "3. 복부에 힘을 주고 몸을 앞으로 들어 올린다. 수축을 몇 초간 유지한다. 턱은 약간 잡아당긴다. 운동을 실시하는 동안 복근을 계속 수축하게 한다. " +
                                "의식적으로 힘을 주면서 복부의 모든 근육에 대해 집중하면서 운동하는 것이 매우 중요하다. 그것과 동시에 둔부에 힘을 주고 발가락을 바닥에 지지대 삼아 " +
                                "뒤꿈치를 밀어 주면서 하체 전체를 뒤로 밀어내는 감각으로 뻗으면 엉덩이도 자연스럽게 내려오고 어깨와 팔에 하중이 경감된다. 고개는 너무 떨구는 일이 없도록 한다. \n\n" +
                                "4. 이 자세를 최소 15초 동안 유지한다.");
                        break;
                    case 4:
                        training_name.setText("크런치");
                        training_example_text.setText("1. 바닥에 누워서 다리를 고정시키고 시선은 자연스럽게 몸이 바라보는 방향과 같도록 한다.\n\n" +
                                "2. 골반을 살짝 후반경사시켜 허리와 바닥 사이의 공간이 없도록 한다.\n\n" +
                                "3. 시선이 천장을 향하면서 복근을 쥐어짜는 힘으로 상반신을 적당히 든다. 이 때 머리를 과도하게 당기지 않는다.\n\n" +
                                "4. 다시 2번의 자세로 돌아온다.\n\n" +
                                "5 .1 ~ 4 번을 반복한다.");
                        break;
                    case 5:
                        training_name.setText("팔굽혀펴기");
                        training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 6:
                        training_name.setText("싱글레그푸쉬업");
                        training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 어깨와 일직선이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 한발을 곧게 들어올린 상태로 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. " +
                                "균형을 잡으며 몸 전체의 정렬을 유지한다.(목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n"+
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 7:
                        training_name.setText("가슴모아 올리기");
                        training_example_text.setText("1. 가슴앞에 두손을합쳐 합장 자세를 취한다.\n\n"+
                                "2. 천천히 손을 위로 올린다. 양쪽 팔꿈치가 서로 닿을수 있을때까지 올린다.\n\n" +
                                "3. 일정시간 후 다시 1번 자세를 취한다.");
                        break;
                    case 8:
                        training_name.setText("스쿼트");
                        training_example_text.setText("1. 양발을 어깨너비로 벌리고 양손은 깍지를끼거나 앞으로 뻗는다.\n\n" +
                                "2. 양발 끝은 바깥쪽으로 약간 벌려준다.\n\n" +
                                "3. 상체를 꼿꼿히 유지하면서 엉덩이를 뒤로 빼준다.\n\n" +
                                "4. 동시에 천천히 무릎을 굽히면서 허벅지가 바닥과 평행이 될때까지 내려간다.");
                        break;
                    case 9:
                        training_name.setText("런지");
                        training_example_text.setText("1. 두 다리를 골반넓이 정도로 벌린다.\n\n" +
                                "2. 허리를 피며 한 발을 앞으로 내딛는다\n\n" +
                                "3. 내딛은 무릎을 직각으로 굽히고 반대쪽 무릎이 바닥에 닿기 직전까지 내려간다..\n\n" +
                                "4. 내딛은 다리로 밀어내며 1번으로 돌아가서 다시 반대쪽도 동일하게 시행한다.");
                        break;
                    case 10:
                        training_name.setText("측면운동");
                        training_example_text.setText("1. 발을 모으고 등을 곧게 편다 손은 앞으로 모은다.\n\n" +
                                "2. 다리 한쪽을 옆으로 뻗는다 반대편 다리의 무릎은 약간 구부린다.\n\n" +
                                "3. 스쿼트 자세처럼 엉덩이를 뒤로 빼주면서 자세를 낮춘다.");
                        break;
                    case 11:
                        training_name.setText("사이드레그레이즈");
                        training_example_text.setText("1. 옆으로 누운 후 다리를 곧게 펴준다.\n\n" +
                                "2. 한 손으로 머리를 받친 후 나머지 손은 바닥을 짚는다.\n\n" +
                                "3. 위쪽 다리를 들어올리고 내린다.");
                        break;
                    case 12:
                        training_name.setText("사이드레그레이즈");
                        training_example_text.setText("1. 옆으로 누운 후 다리를 곧게 펴준다.\n\n" +
                                "2. 한 손으로 머리를 받친 후 나머지 손은 바닥을 짚는다.\n\n" +
                                "3. 위쪽 다리를 들어올리고 내린다.");
                        break;
                    case 13:
                        training_name.setText("마무리");
                        training_example_text.setText("1. 양손을 어깨너비, 무릎은 골반 너비로 벌린 자세로 엎드린 후 허리는 바닥과 수평을 이루게한다.\n\n" +
                                "2. 턱을 안쪽으로 당기고 등을 말아서 위로 들어올린다. 숨을 천천히 내쉰다.\n\n"+
                                "3. 손과 무릎은 고정한 채 양팔을 앞으로 쭉 뻗으며 엎드려 앉는다.\n\n"+
                                "4. 몸을 최대한 바닥에 붙여 늘어뜨린 후 편안하게 호흡한다.");
                        break;
                }
                break;



            case 102:
                switch (pos){
                    case 0:
                        training_name.setText("팔벌려뛰기");
                        training_example_text.setText("1. 발을 어깨너비로 벌리고 팔을 몸통 옆에 둡니다.\n\n" +
                                "2. 점프하면서 다리를 어깨너비보다 넓게 벌리고 팔을 벌려 머리 위로 올려줍니다\n\n"+
                                "3. 다시 점프하여 다리를 모으고 팔을 내립니다.");
                        break;
                    case 1:
                        training_name.setText("윗몸일으키기");
                        training_example_text.setText("1. 무릎을 90도 각도로구부리고 등을 바닥에 대고 눞는다.\n\n"+
                                "2. 양팔을 교차해서 서로 반대 어깨에 손을 댄다.\n\n"+
                                "3. 복근과 허벅지 힘으로 몸통을 들어올려 팔꿈치를 무릎에 댄다.\n\n"+
                                "4. 올릴때와 마찬가지로 힘을 주고 안정적으로 시작 자세로 돌아간다.");
                        break;
                    case 2:
                        training_name.setText("바이시클메뉴버");
                        training_example_text.setText("1. 누운 자세에서 양손을 머리 뒤에 또는 귀옆에 둔다.\n\n" +
                                "2. 양다리를 살짝 들어 올리고 자전거 페달을 밟듯이 무릎을 번갈아 가면서 천천히 가슴 쪽으로 굽혔다가 편다. 이때 아래에 있는 다리는 바닥에 닿지 않을 정도로 살짝 띄운다.\n\n" +
                                "3. 2번 자세에 익숙해졌다면 상체를 들어 올리고 오른쪽 무릎을 당기면서 왼쪽 팔꿈치가 오른쪽 무릎에 닿을 정도로 허리를 살짝 튼다. 이때 왼쪽 다리는 들어 올린 상태에서 편다.\n\n" +
                                "4. 서서히 오른쪽 다리를 펴면서 왼쪽 무릎을 당기고, 오른쪽 팔꿈치가 왼쪽 무릎에 닿을 정도로 상체를 들어 허리를 살짝 튼다.\n\n" +
                                "5. 3~4번 동작을 천천히 반복한다.");
                        break;
                    case 3:
                        training_name.setText("마운틴 클라이머");
                        training_example_text.setText("1. 팔을 가슴아래를받치고 지면과 수직으로 엎드려뻗쳐 자세를 유지한다.\n\n"+
                                "2. 허리가 아래로 내려가지않도록 복부에 긴장감을 유지해주고 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n"+
                                "3. 한쪽 무릎을 가슴까지 오도록 당겨준다.\n\n"+
                                "4. 원위치 후 반대쪽 무릎을 당겨준다.\n\n"+
                                "5. 다리를 바꿔가며 최대한빠르게 반복한다.");
                        break;
                    case 4:
                        training_name.setText("플랭크");
                        training_example_text.setText("1. 엎드린 자세에서 팔뚝으로 중심을 잡고 다리는 약간 벌린 상태로 일자를 유지한다. 몸은 전체에 걸쳐 일자상태를 유지한다.\n\n" +
                                "2. 팔꿈치와 어깨는 일자를 유지한다. \n\n" +
                                "3. 복부에 힘을 주고 몸을 앞으로 들어 올린다. 수축을 몇 초간 유지한다. 턱은 약간 잡아당긴다. 운동을 실시하는 동안 복근을 계속 수축하게 한다. " +
                                "의식적으로 힘을 주면서 복부의 모든 근육에 대해 집중하면서 운동하는 것이 매우 중요하다. 그것과 동시에 둔부에 힘을 주고 발가락을 바닥에 지지대 삼아 " +
                                "뒤꿈치를 밀어 주면서 하체 전체를 뒤로 밀어내는 감각으로 뻗으면 엉덩이도 자연스럽게 내려오고 어깨와 팔에 하중이 경감된다. 고개는 너무 떨구는 일이 없도록 한다. \n\n" +
                                "4. 이 자세를 최소 15초 동안 유지한다.");
                        break;
                    case 5:
                        training_name.setText("크런치");
                        training_example_text.setText("1. 바닥에 누워서 다리를 고정시키고 시선은 자연스럽게 몸이 바라보는 방향과 같도록 한다.\n\n" +
                                "2. 골반을 살짝 후반경사시켜 허리와 바닥 사이의 공간이 없도록 한다.\n\n" +
                                "3. 시선이 천장을 향하면서 복근을 쥐어짜는 힘으로 상반신을 적당히 든다. 이 때 머리를 과도하게 당기지 않는다.\n\n" +
                                "4. 다시 2번의 자세로 돌아온다.\n\n" +
                                "5 .1 ~ 4 번을 반복한다.");
                        break;
                    case 6:
                        training_name.setText("코브라스트레칭");
                        training_example_text.setText("1. 엎드린 상태에서 손을 가슴 옆에 둔다. 손가락 사이를 펼치고 손바닥 안쪽이 뜨지 않도록 손바닥 전체로 바닥을 눌러준다.\n\n"+
                                "2. 어깨로 버티지 않도록 팔꿈치를 뒤로 밀어주고 옆구리에 붙여준다.\n\n"+
                                "3. 발을 골반 너비로 벌리고 발등으로 바닥을 눌러준다. 누르는 힘이 엉덩이까지 느껴지도록 한다.\n\n"+
                                "4. 복부에 힘을 주고 손으로 바닥을 밀어 상체를 천천히 들어올린다. 어깨가 올라가지 않도록 주의해야한다.");
                        break;
                    case 7:
                        training_name.setText("팔굽혀펴기");
                        training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 지면과 직각이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 8:
                        training_name.setText("싱글레그푸쉬업");
                        training_example_text.setText("1. 팔을 어깨너비보다 약간 벌린 상태에서 팔이 어깨와 일직선이 되도록 아래로 뻗고 몸은 일자를 유지한다.\n\n" +
                                "2. 한발을 곧게 들어올린 상태로 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. " +
                                "균형을 잡으며 몸 전체의 정렬을 유지한다.(목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n"+
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 9:
                        training_name.setText("디클라인푸쉬업");
                        training_example_text.setText("양발은 높은 곳에 올리고 양손은 어깨너비보다 약간 벌려 몸은 일자를 유지한다.\n\n" +
                                "2. 가슴이 바닥에 거의 닿을때까지 팔꿈치를 몸에 가깝게 구부리면서 몸을 내린다. (목과어깨에 과도한힘이 들어가지않게 조심한다.)\n\n" +
                                "3. 팔꿈치를 피면서 시작자세로 돌아간다. (일자 유지)");
                        break;
                    case 10:
                        training_name.setText("버피");
                        training_example_text.setText("1. 차렷자세로 시작한다.\n\n"+
                                "2. 상체를 숙여주며 바닥에 양손을 집는다.\n\n"+
                                "3. 푸쉬업 자세를 만든다.\n\n"+
                                "4. 2번 1번 순으로 다시 돌아간다.");
                        break;
                    case 11:
                        training_name.setText("가슴모아 올리기");
                        training_example_text.setText("1. 가슴앞에 두손을합쳐 합장 자세를 취한다.\n\n"+
                                "2. 천천히 손을 위로 올린다. 양쪽 팔꿈치가 서로 닿을수 있을때까지 올린다.\n\n" +
                                "3. 일정시간 후 다시 1번 자세를 취한다.");
                        break;
                    case 12:
                        training_name.setText("스쿼트");
                        training_example_text.setText("1. 양발을 어깨너비로 벌리고 양손은 깍지를끼거나 앞으로 뻗는다.\n\n" +
                                "2. 양발 끝은 바깥쪽으로 약간 벌려준다.\n\n" +
                                "3. 상체를 꼿꼿히 유지하면서 엉덩이를 뒤로 빼준다.\n\n" +
                                "4. 동시에 천천히 무릎을 굽히면서 허벅지가 바닥과 평행이 될때까지 내려간다.");
                        break;
                    case 13:
                        training_name.setText("런지");
                        training_example_text.setText("1. 두 다리를 골반넓이 정도로 벌린다.\n\n" +
                                "2. 허리를 피며 한 발을 앞으로 내딛는다\n\n" +
                                "3. 내딛은 무릎을 직각으로 굽히고 반대쪽 무릎이 바닥에 닿기 직전까지 내려간다..\n\n" +
                                "4. 내딛은 다리로 밀어내며 1번으로 돌아가서 다시 반대쪽도 동일하게 시행한다.");
                        break;
                    case 14:
                        training_name.setText("측면운동");
                        training_example_text.setText("1. 발을 모으고 등을 곧게 편다 손은 앞으로 모은다.\n\n" +
                                "2. 다리 한쪽을 옆으로 뻗는다 반대편 다리의 무릎은 약간 구부린다.\n\n" +
                                "3. 스쿼트 자세처럼 엉덩이를 뒤로 빼주면서 자세를 낮춘다.");
                        break;
                    case 15:
                        training_name.setText("사이드레그레이즈");
                        training_example_text.setText("1. 옆으로 누운 후 다리를 곧게 펴준다.\n\n" +
                                "2. 한 손으로 머리를 받친 후 나머지 손은 바닥을 짚는다.\n\n" +
                                "3. 위쪽 다리를 들어올리고 내린다.");
                        break;
                    case 16:
                        training_name.setText("사이드레그레이즈");
                        training_example_text.setText("1. 옆으로 누운 후 다리를 곧게 펴준다.\n\n" +
                                "2. 한 손으로 머리를 받친 후 나머지 손은 바닥을 짚는다.\n\n" +
                                "3. 위쪽 다리를 들어올리고 내린다.");
                        break;
                    case 17:
                        training_name.setText("마무리");
                        training_example_text.setText("1. 양손을 어깨너비, 무릎은 골반 너비로 벌린 자세로 엎드린 후 허리는 바닥과 수평을 이루게한다.\n\n" +
                                "2. 턱을 안쪽으로 당기고 등을 말아서 위로 들어올린다. 숨을 천천히 내쉰다.\n\n"+
                                "3. 손과 무릎은 고정한 채 양팔을 앞으로 쭉 뻗으며 엎드려 앉는다.\n\n"+
                                "4. 몸을 최대한 바닥에 붙여 늘어뜨린 후 편안하게 호흡한다.");
                        break;
                }break;
        }

    }



    public void example_ok(View v){

        switch (tag){
            case 2:
                finish();
                break;
            case 11:
                setResult(11);
                finish();
                break;

        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (tag){
                    case 1:
                        intent.putExtra("start",1);
                        intent.putExtra("getcount",getcount);
                        setResult(1000,intent);
                        finish();
                        break;
                    case 10:
                        intent.putExtra("getcount",getcount);
                        setResult(10,intent);
                        finish();
                        break;
                }
                finish();
            }
        },1000);
    }

    //바깥레이어 클릭시 안닫히게
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    //안드로이드 백버튼 막기
    @Override
    public void onBackPressed() {
        return;
    }
}