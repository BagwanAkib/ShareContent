package in.akib.content_core;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Bagwan Akib on 5/22/2020. for in.akib.content_core
 */
public class Share {

    public static String getFileNameFromURI(Uri uri, Context context) {
        String result = null;
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try (Cursor cursor = context.getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut;
            if (result != null) {
                cut = result.lastIndexOf('/');
                if (cut != -1) {
                    result = result.substring(cut + 1);
                }
            }
        }
        return result;
    }

    /**
     * select application package name and pass to app string so it will open the share
     * for that respective application
     *
     * @param app         ApplicationName.FACEBOOK ApplicationName.WHATSAPP..
     * @param context     for retrieving file from URI
     * @param text        this will help you to pass the text to the application as extra text
     * @param uri         this is an option field if you have @param pictureFile with you
     * @param pictureFile is an optional field if you have uri
     *                    uri or pictureFile single field must be there
     */
    public static void shareFileOnSelectedApp(String app, Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage(app);
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "WhatsApp have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * select application package name and pass to app string so it will open the share
     * for that respective application
     *
     * @param context for retrieving file from URI
     * @param title   add title to share with app
     * @param text    this will help you to pass the text to the application as extra text
     *                uri or pictureFile single field must be there
     */
    public static void shareText(Context context, String title, String text) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TITLE, title);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/plain");
        try {
            context.startActivity(Intent.createChooser(shareIntent, "Share"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "WhatsApp have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnWhatsApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage("com.whatsapp");
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "WhatsApp have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnFacebookApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage("com.facebook.katana");
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Facebook have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnTwitterApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage("com.twitter.android");
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Twitter have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnInstagramApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage("com.instagram.android");
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Instagram have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnPinterestApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setPackage("com.pinterest");
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Pinterests have not been installed.", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareOnOtherApp(Context context, String text, Uri uri, File pictureFile) {
        Uri imageUri;
        if (uri != null)
            imageUri = uri;
        else
            imageUri = Uri.parse(pictureFile.getAbsolutePath());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        //Add text and then Image URI
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(shareIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Selected App not been installed.", Toast.LENGTH_LONG).show();
        }
    }
}
