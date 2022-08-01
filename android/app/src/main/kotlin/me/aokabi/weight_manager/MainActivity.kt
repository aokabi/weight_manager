package me.aokabi.weight_manager
import android.os.Bundle
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngine
import android.util.Log


class MainActivity: FlutterActivity() {
    companion object {
        private const val CHANNEL_NAME = "camera"
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL_NAME).setMethodCallHandler { methodCall, result ->
            when (methodCall.method) {
                "launchCamera" -> (methodCall.arguments as HashMap<String, *>)["enabled"]?.let {
                    launchCamera()
                    result.success(null)
                }
                else -> result.notImplemented()
            }
        }
    }

    private fun launchCamera() {
        Log.d("DEBUG", "launch camera")
    }

}
