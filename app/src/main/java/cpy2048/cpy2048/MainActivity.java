package cpy2048.cpy2048;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements GestureDetector.OnGestureListener{
	private GestureDetector gd;
	int iCol=0;
	int nWidth;
	int nHeight;
	int nRectX;
	int nRectY;
	List<ViewCell> list = new ArrayList<ViewCell>();
	LinearLayout ctrlBoxLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		WindowManager wm = getWindowManager();
		Display dp = wm.getDefaultDisplay();
		Point pt = new Point();
		dp.getSize(pt);
		nWidth = pt.x;
		nHeight = pt.y;

		nRectX = nWidth / 4;
		nRectY = nRectX;
		int nSurplus = nHeight - nWidth;

		LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(nWidth,nWidth);
		ctrlBoxLayout = new LinearLayout(this);
		ctrlBoxLayout.setLayoutParams(layoutParam);
		ctrlBoxLayout.setOrientation(LinearLayout.VERTICAL);
		ctrlBoxLayout.setBackgroundColor(Color.WHITE);

		LinearLayout surplusLayout = new LinearLayout(this);
		surplusLayout.setLayoutParams(new LinearLayout.LayoutParams(nWidth, nSurplus));
		surplusLayout.setBackground(getResources().getDrawable(R.drawable.ddd));
		TextView textView = new TextView(this);
		textView.setTextColor(Color.RED);
		textView.setText("盗图什么的我从来不干的╭(╯^╰)╮");
		textView.setTextSize(30);
		surplusLayout.addView(textView);
		ctrlBoxLayout.addView(surplusLayout);
		ctrlBoxLayout.addView(getMainLayout());
		View scode = View.inflate(this, R.layout.activity_main, null);
		ctrlBoxLayout.addView(scode);
		gd = new GestureDetector(this);
		setContentView(ctrlBoxLayout);
	}
	View getMainLayout()
	{
		LinearLayout colLyaout = new LinearLayout(this);
		colLyaout.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < 4; i++)
		{
			iCol = i;
			colLyaout.addView(getRowLayout());
		}
		return colLyaout;
	}
	View getRowLayout()
	{
		LinearLayout rowLayout = new LinearLayout(this);
		rowLayout.setOrientation(LinearLayout.HORIZONTAL);
		for (int i= 0; i < 4; i++)
		{
			int ns = iCol * 4 + i + 1;
			ViewCell vCell = new ViewCell(this, nRectX, nRectY, ns);
			rowLayout.addView(vCell);
			list.add(vCell);
		}
		return rowLayout;
	}

	@Override
	public boolean onDown(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent motionEvent) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent motionEvent) {

	}

	@Override
	public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
		return false;
	}

}
