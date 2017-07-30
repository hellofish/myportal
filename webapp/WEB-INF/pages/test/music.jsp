<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="myAudio" style="margin:0 auto;">
  <audio>
    <source title="王若琳 - Wild World.mp3" src="http://music.huoxing.com/upload/20121215/1355575227640_8200.mp3" />
    <source title="韦礼安 - 还是会.mp3" src="http://stream18.qqmusic.qq.com/31005070.mp3" />
    <source title="王若琳 - Lost in paradise.mp3" src="http://stream12.qqmusic.qq.com/30416842.mp3" />
  </audio>
  <div class="music_info clearfix">
    <div class="cd_holder"><span class="stick"></span><div class="cd"></div></div>
    <div class="meta_data">
      <span class="title"></span>
      <div class="rating">
        <div class="starbar">
          <ul class="current-rating" data-score="85">
            <li class="star5"></li>
            <li class="star4"></li>
            <li class="star3"></li>
            <li class="star2"></li>
            <li class="star1"></li>
          </ul>
        </div>
      </div>
      <div class="volume_control">
        <a class="decrease">a</a>
        <span class="base_bar">
          <span class="progress_bar"></span>
          <a class="slider"></a>
        </span>
        <a class="increase">b</a>
      </div>
    </div>
  </div>
  <ul class="music_list"></ul>
  <div class="controls">
    <div class="play_controls">
      <a class="btn_previous">e</a>
      <a class="btn_play">c</a>
      <a class="btn_next">d</a>
    </div>
    <div class="time_line">
      <span class="passed_time">0:00</span>
      <span class="base_bar">
        <span class="progress_bar"></span>
      </span>
      <span class="total_time">0:00</span>
    </div>
  </div>
</div>
</body>
</html>