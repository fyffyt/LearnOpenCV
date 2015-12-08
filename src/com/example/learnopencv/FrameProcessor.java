package com.example.learnopencv;

import org.opencv.core.CvType;
import org.opencv.core.Scalar;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.core.Point;
import org.opencv.core.Core;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import android.util.Log;

public class FrameProcessor {
	public static final String TAG = "FrameProcessor";
	
	public Mat divideFrame(Mat inputFrame){
		Log.d(TAG, "begin to process Frame.");
		Rect roiRect1 = new Rect(0,0,inputFrame.width()/2, inputFrame.height());
		Rect roiRect2 = new Rect(inputFrame.width()/2, 0, inputFrame.width()/2, inputFrame.height() );
		Log.d(TAG, "begin to create ROI.");
		Mat roi1 = new Mat(inputFrame, roiRect1);
		Mat roi2 = new Mat(inputFrame, roiRect2);
		Log.d(TAG, "begin to copy Frame.");
		//roi1.copyTo(roi2);
		
		Imgproc.GaussianBlur(roi1, roi2, new Size(7, 7), 1.5, 1.5);
		
		drawLine(inputFrame);
		return inputFrame;
	}
	
	private void drawLine(Mat frame){
		Core.line(frame, new Point(frame.width()/2-1, 0), new Point(frame.width()/2-1, frame.height() ), new Scalar(255,0,0,255));
		Core.line(frame, new Point(frame.width()/2, 0), new Point(frame.width()/2, frame.height() ), new Scalar(255,0,0,255));
	}

}
