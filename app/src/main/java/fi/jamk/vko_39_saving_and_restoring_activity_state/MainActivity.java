package fi.jamk.vko_39_saving_and_restoring_activity_state;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements EnterTextDialogFragment.TextEntryDialogListener {


    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView1);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTVIEW_STATEKEY)) {
                String text = savedInstanceState.getString(TEXTVIEW_STATEKEY);
                textView.setText(text);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        Toast.makeText(getBaseContext(), "I remember the messsage!", Toast.LENGTH_SHORT).show();
        // get text view
        TextView textView = (TextView) findViewById(R.id.textView1);
        // save text view state
        saveInstanceState.putString(TEXTVIEW_STATEKEY, textView.getText().toString());
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText(text);
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel",
                Toast.LENGTH_SHORT).show();
    }

    public void buttonClicked(View view) {
        EnterTextDialogFragment eDialog = new EnterTextDialogFragment();
        eDialog.show(getFragmentManager(), "Text Dialog");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
