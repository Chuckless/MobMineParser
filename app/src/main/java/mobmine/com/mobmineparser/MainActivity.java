package mobmine.com.mobmineparser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import mobmine.com.mobmineparser.Util.fromXml;
import mobmine.com.mobmineparser.Util.toXml;
import mobmine.com.mobmineparser.Domain.Point;
import mobmine.com.mobmineparser.Singleton.Constants;
import mobmine.com.mobmineparser.Util.InternalStorage;


public class MainActivity extends Activity {

    @Override

//AEHIOAESHIOAHIOSE
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constants.aplicationContext = getApplicationContext();


            ArrayList<Point> points = InternalStorage.readGPSFile(getApplicationContext(),
                    Constants.GPSFOLDERNAME, "gpsvale.txt");
            String xml = toXml.toXml(points);
            InternalStorage.writeFile(getApplicationContext(), Constants.XMLFOLDERNAME,
                    "XmlTeste.xml", xml);
            fromXml.fromXml("XmlTeste.xml");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
