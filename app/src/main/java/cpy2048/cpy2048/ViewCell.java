package cpy2048.cpy2048;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Jafo on 2015/4/29.
 */
public class ViewCell extends View {
	RectF r = new RectF();int ii;
	public ViewCell(Context context, int X, int Y, int i) {
		super(context);
		setLayoutParams(new LinearLayout.LayoutParams(X, Y));
		r.set(0, 0, this.getWidth(), this.getHeight());
		r.inset(2, 2);ii=i;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		this.setBackgroundColor(Color.parseColor("#CCC0B3"));
		Paint paint = new Paint();
		paint.setShader(null);
		paint.setColor(Color.parseColor("#CCC0B3"));
		canvas.drawRect(r, paint);

		paint.setColor(Color.BLACK);
		paint.setTextSize(32);
		paint.setFakeBoldText(true);
		String snumber="" + ii;

		Paint pText = new Paint(paint);
		pText.setTextSize(pText.getTextSize() * 5);
		pText.setTypeface(Typeface.DEFAULT_BOLD);
		pText.setColor(Color.BLACK);
		final int x =  ((int) r.left + ((int) r.width() >> 1)
				+ (int)(pText.getTextSize()));

		final int y = (int) (this.getHeight()
				- (this.getHeight() - pText.getTextSize()) / 2 - pText.getFontMetrics().bottom);
		canvas.drawText(snumber, x - 80, y + 30, pText);
		//onDrawBorder(canvas);

		paint.setShader(null);
		paint.setStrokeWidth(16);
		paint.setColor(Color.WHITE);
		canvas.drawLine(0, 0, 0, this.getHeight(), paint);
		canvas.drawLine(0, 0, this.getWidth(), 0, paint);
		canvas.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight(), paint);
		canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight(), paint);
	}
}
