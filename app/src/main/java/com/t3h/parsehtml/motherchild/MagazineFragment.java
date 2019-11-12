package com.t3h.parsehtml.motherchild;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.t3h.parsehtml.CommonCrawl;
import com.t3h.parsehtml.R;
import com.t3h.parsehtml.model.MotherChildModel;
import com.t3h.parsehtml.motherchild.adapter.MotherChilAdapter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SecureCacheResponse;
import java.util.ArrayList;
import java.util.List;

public class MagazineFragment extends BaseMotherChildFragment {

}
