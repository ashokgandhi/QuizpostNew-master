package com.example.india.quizpost.Tutorial;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.india.quizpost.ProjectClassFile.TutorialActivity;
import com.example.india.quizpost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IosTutorial extends AppCompatActivity {
    /** ButterKnife Code **/
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.arrowback)
    TextView arrowback;

    private ImageButton bt_toggle_q1, bt_toggle_q2, bt_toggle_q3,bt_toggle_q4,bt_toggle_q5,bt_toggle_q6,bt_toggle_q7,bt_toggle_q8,bt_toggle_q9,bt_toggle_q10,bt_toggle_q11,bt_toggle_q12,bt_toggle_q13,bt_toggle_q14,bt_toggle_q15,bt_toggle_q16,bt_toggle_q17,bt_toggle_q18,bt_toggle_q19,bt_toggle_q20 ;
    private View lyt_expand_q1, lyt_expand_q2, lyt_expand_q3,lyt_expand_q4,lyt_expand_q5,lyt_expand_q6,lyt_expand_q7,lyt_expand_q8,lyt_expand_q9,lyt_expand_q10,lyt_expand_q11,lyt_expand_q12,lyt_expand_q13,lyt_expand_q14,lyt_expand_q15,lyt_expand_q16,lyt_expand_q17,lyt_expand_q18,lyt_expand_q19,lyt_expand_q20;
    private NestedScrollView nested_scroll_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ios_tutorial);
        ButterKnife.bind(this);
        // section items
        initComponent();

    }

    @OnClick(R.id.arrowback)
    void register() {
        Intent intent = new Intent(IosTutorial.this, TutorialActivity.class);
        startActivity(intent);

    }
    private void initComponent () {
        // nested scrollview
        nested_scroll_view = (NestedScrollView) findViewById( R.id.nested_scroll_view );

        // section items
        bt_toggle_q1 = (ImageButton) findViewById( R.id.bt_toggle_q1 );
        lyt_expand_q1 = (View) findViewById( R.id.lyt_expand_q1 );

        bt_toggle_q1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q1 );


            }
        } );
        // section address
        bt_toggle_q2 = (ImageButton) findViewById( R.id.bt_toggle_q2 );
        lyt_expand_q2 = (View) findViewById( R.id.lyt_expand_q2 );
        bt_toggle_q2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q2 );
            }
        } );

        // section description
        bt_toggle_q3= (ImageButton) findViewById( R.id.bt_toggle_q3 );
        lyt_expand_q3 = (View) findViewById( R.id.lyt_expand_q3 );
        bt_toggle_q3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q3 );
            }
        } );
        bt_toggle_q4=findViewById( R.id.bt_toggle_q4 );
        lyt_expand_q4=(View)findViewById( R.id.lyt_expand_q4 );
        bt_toggle_q4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q4);
            }
        } );
        bt_toggle_q5=findViewById( R.id.bt_toggle_q5 );
        lyt_expand_q5=(View)findViewById( R.id.lyt_expand_q5);
        bt_toggle_q5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q5);
            }
        } );

        bt_toggle_q6=findViewById( R.id.bt_toggle_q6);
        lyt_expand_q6=(View)findViewById( R.id.lyt_expand_q6 );
        bt_toggle_q6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q6);
            }
        } );
        bt_toggle_q7=findViewById( R.id.bt_toggle_q7 );
        lyt_expand_q7=(View)findViewById( R.id.lyt_expand_q7 );
        bt_toggle_q7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q7);
            }
        } );

        bt_toggle_q8=findViewById( R.id.bt_toggle_q8 );
        lyt_expand_q8=(View)findViewById( R.id.lyt_expand_q8 );
        bt_toggle_q8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q8);
            }
        } );
        bt_toggle_q9=findViewById( R.id.bt_toggle_q9 );
        lyt_expand_q9=(View)findViewById( R.id.lyt_expand_q9 );
        bt_toggle_q9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q9);
            }
        } );
        bt_toggle_q10=findViewById( R.id.bt_toggle_q10);
        lyt_expand_q10=(View)findViewById( R.id.lyt_expand_q10);
        bt_toggle_q10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                toggleSection(v,lyt_expand_q10);
            }
        } );
        bt_toggle_q11 = (ImageButton) findViewById( R.id.bt_toggle_q11 );
        lyt_expand_q11 = (View) findViewById( R.id.lyt_expand_q11 );

        bt_toggle_q11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q11 );


            }
        } );
        bt_toggle_q12 = (ImageButton) findViewById( R.id.bt_toggle_q12 );
        lyt_expand_q12 = (View) findViewById( R.id.lyt_expand_q12 );

        bt_toggle_q12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q12 );


            }
        } );


        bt_toggle_q13 = (ImageButton) findViewById( R.id.bt_toggle_q13);
        lyt_expand_q13 = (View) findViewById( R.id.lyt_expand_q13 );

        bt_toggle_q13.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q13 );


            }
        } );


        bt_toggle_q14 = (ImageButton) findViewById( R.id.bt_toggle_q14 );
        lyt_expand_q14 = (View) findViewById( R.id.lyt_expand_q14 );

        bt_toggle_q14.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q14 );


            }
        } );


        bt_toggle_q15 = (ImageButton) findViewById( R.id.bt_toggle_q15 );
        lyt_expand_q15 = (View) findViewById( R.id.lyt_expand_q15 );

        bt_toggle_q15.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q15 );


            }
        } );


        bt_toggle_q16 = (ImageButton) findViewById( R.id.bt_toggle_q16 );
        lyt_expand_q16 = (View) findViewById( R.id.lyt_expand_q16 );

        bt_toggle_q16.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q16 );


            }
        } );


        bt_toggle_q17 = (ImageButton) findViewById( R.id.bt_toggle_q17 );
        lyt_expand_q17 = (View) findViewById( R.id.lyt_expand_q17 );

        bt_toggle_q17.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q17 );


            }
        } );

        bt_toggle_q18 = (ImageButton) findViewById( R.id.bt_toggle_q18 );
        lyt_expand_q18 = (View) findViewById( R.id.lyt_expand_q18 );

        bt_toggle_q18.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q18 );


            }
        } );






        bt_toggle_q19 = (ImageButton) findViewById( R.id.bt_toggle_q19 );
        lyt_expand_q19 = (View) findViewById( R.id.lyt_expand_q19 );

        bt_toggle_q19.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q19 );


            }
        } );

        bt_toggle_q20 = (ImageButton) findViewById( R.id.bt_toggle_q20 );
        lyt_expand_q20 = (View) findViewById( R.id.lyt_expand_q20 );

        bt_toggle_q20.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                toggleSection( view, lyt_expand_q20);


            }
        } );
    }

    private void toggleSection (View bt, final View lyt) {
        boolean show = toggleArrow( bt );
        if (show) {
            ViewAnimation.expand( lyt, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish () {
                    Tools.nestedScrollTo( nested_scroll_view, lyt );
                }
            } );
        } else {
            ViewAnimation.collapse( lyt );
        }
    }

    public boolean toggleArrow (View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration( 200 ).rotation( 180 );
            return true;
        } else {
            view.animate().setDuration( 200 ).rotation( 0 );
            return false;

        }
    }
}
