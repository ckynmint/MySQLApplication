package com.krootoom.mysqlapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");

        final EditText editText = (EditText)findViewById(R.id.edit_editText);
        editText.setText(editTodoList.getTaskname());

        Button editbtn = (Button)findViewById(R.id.edit_button);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();
                eTodoList.setTaskid(editTodoList.getTaskid());
                eTodoList.setTaskname(String.valueOf(editText.getText()));

                TodoListDAO todoListDAO = new TodoListDAO((getApplicationContext()));
                todoListDAO.open();
                todoListDAO.update(eTodoList);
                todoListDAO.close();

                finish();
            }
        });
        Button delbtn = (Button) findViewById(R.id.delete_btn);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListDAO todoListDAODel = new TodoListDAO(getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();

                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_add_new_menu){
            Intent addNewIntent = new Intent(this,AddDataActivity.class);
            startActivity(addNewIntent);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
