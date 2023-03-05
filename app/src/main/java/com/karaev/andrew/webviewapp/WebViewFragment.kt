package com.karaev.andrew.webviewapp

import android.net.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider



private lateinit var cld : ConnectionLiveData

class WebViewFragment : Fragment() {
    private lateinit var webView: WebView
    private lateinit var textViewStatus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.webview_fragment, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webview)
        textViewStatus = view.findViewById(R.id.textViewStatus)
        checkNetworkConnection(view)


        }


    private fun checkNetworkConnection(view:View) {
        cld = ConnectionLiveData(view.context)

        cld.observe(viewLifecycleOwner, Observer { isConnected ->
            if (isConnected){

                webView.visibility = View.VISIBLE
                webView.loadUrl("https://www.google.ru/")

            }else{
                webView.visibility = View.GONE
                textViewStatus.visibility = View.VISIBLE

            }
        })
    }
}






