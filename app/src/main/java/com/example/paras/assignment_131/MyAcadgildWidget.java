package com.example.paras.assignment_131;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class MyAcadgildWidget extends AppWidgetProvider {
    public static final int REQUEST = 0;
    public static final int FLAG = 0;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_acadgild_widget);

        // intent to open the website by uri method.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acadgild.com"));
        // create a pending intent for the above intent.
        PendingIntent pendInt = PendingIntent.getActivity(context, REQUEST , intent,FLAG);

        // sets the action for the onclick event on the widget using pending intent.
        views.setOnClickPendingIntent(R.id.appwidget_text, pendInt);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

