package ru.gordeev.sprites.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;

import ru.gordeev.sprites.R;

public class MyView extends View {

    private int i = 0;
    private Bitmap image;

    public MyView(Context context) {
        super(context);
        new Timer(Integer.MAX_VALUE, 500).start();
        image = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sprite);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);

        int h = image.getHeight();
        int w = image.getWidth();
        int step = w / 6;
        Rect dst = new Rect(0, 0, step, h);
        if (i < 5) {
            Rect src = new Rect(step * i, 0, step * (i + 1), h);
            canvas.drawBitmap(image, src, dst, p);
            i = i + 1;
        } else {
            Rect src = new Rect(step * i, 0, step * (i + 1), h);
            canvas.drawBitmap(image, src, dst, p);
            i = 0;
        }

    }

    public class Timer extends CountDownTimer {
        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }
}
