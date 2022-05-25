<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.98.0">
    <title>EX</title>
    
	<jsp:include page="../views/includes/head.jsp"></jsp:include>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>
    
  </head>
  <body>
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Company name</a>
  <!-- <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search" aria-label="Search">
  <div class="navbar-nav">
   
  </div> -->
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3 d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 100%; height: 100% ;">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
          <svg class="bi pe-none me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-4">ERP</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
          <li class="nav-item">
            <a href="#" class="nav-link active" aria-current="page">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
              HOME
            </a>
          </li>
          <li>
            <a href="#" class="nav-link text-white">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
              인사관리
            </a>
          </li>
          <li>
            <a href="#" class="nav-link text-white">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
              부서관리
            </a>
          </li>
          <li>
            <a href="#" class="nav-link text-white">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
              달력
            </a>
          </li>
          <li>
            <a href="/notice" class="nav-link text-white">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
              공지사항
            </a>
          </li>
          <li>
            <a href="#" class="nav-link text-white">
              <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
              지출관리
            </a>
          </li>
        </ul>
        <hr>
        <div class="dropdown">
          <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
            <strong>mdo</strong>
          </a>
          <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
          </div>
          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar" class="align-text-bottom"></span>
            This week
          </button>
        </div>
      </div>
   
      </svg>
      
      <div class="content">
        <div class="row align-items-start">
          
          <jsp:include page="notice/view.jsp"></jsp:include>
          
          <div class="col-md-6">
            <h2>회사일정</h2>
            <div id="menu">
              <span id="menu-navi">
                <button type="button" class="btn btn-default btn-sm move-today" data-action="move-today">Today</button>
                <button type="button" class="btn btn-default btn-sm move-day" data-action="move-prev">
                  <i class="bi bi-arrow-left"></i>
                </button>
                <button type="button" class="btn btn-default btn-sm move-day" data-action="move-next">
                  <i class="bi bi-arrow-right"></i>
                </button>
                <select name="" id="" class="btn-toolbar">
                  <option value="" data-action="change-month">월</option>
                  <option value="" data-action="change-week">주</option>
                  <option value="" data-action="change-day">일</option>
                </select>
              </span>
              <span id="renderRange" class="render-range"></span>
            </div>
            <div id="calendar"></div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6" id="grid3"><h2>게시판</h2></div>
            <div class="col-md-6">
              <h2>임원일정</h2>
              <div id="menu">
                <span id="menu-navi">
                  <button type="button" class="btn btn-default btn-sm move-today" data-action="move-today">Today</button>
                  <button type="button" class="btn btn-default btn-sm move-day" data-action="move-prev">
                    <i class="calendar-icon ic-arrow-line-left" data-action="move-prev"></i>
                  </button>
                  <button type="button" class="btn btn-default btn-sm move-day" data-action="move-next">
                    <i class="calendar-icon ic-arrow-line-right" data-action="move-next"></i>
                  </button>
                </span>
                <span id="renderRange" class="render-range"></span>
              </div>
          
              <div id="calendar2"></div>
            </div>
        </div>
      </div>    
    </main>
  </div>
</div>
<script>
    const gridData =[{
      name: 'qwe',
      artist: '<a href = "https://www.notion.so">이동확인</a>'
    },{
      name: 'rq',
      artist: 'qwe'
    }
  
  ]
    
    const grid3 = new tui.Grid({
      el: document.getElementById('grid3'),
      data: gridData,
      scrollX: false,
      scrollY: false,
      columns: [
        {
          header: 'Name',
          name: 'name'
        },
        {
          header: 'Artist',
          name: 'artist'
        },
        {
          header: 'Type',
          name: 'type'
        },
        {
          header: 'Release',
          name: 'release'
        },
        {
          header: 'Genre',
          name: 'genre'
        }
      ]
    });
</script>
<script>
// 캘린더를 생성하는 방법! 아래 옵션은 popup을 활성화
  var calendar = new tui.Calendar('#calendar', {
    defaultView: 'month',
    useCreationPopup: true,
    useDetailPopup: true
    
  });

  //생성
  calendar.on('beforeCreateSchedule', scheduleData => {
    const schedule = {
      calendarId: scheduleData.calendarId,
      id: String(Math.random() * 100000000000000000),
      title: scheduleData.title,
      isAllDay: scheduleData.isAllDay,
      start: scheduleData.start,
      end: scheduleData.end,
      attendees: scheduleData.attendees,
      category: scheduleData.isAllDay ? 'allday' : 'time',
      location: scheduleData.location             
    };
   calendar.createSchedules([schedule]);
    alert('일정 생성 완료');
  });
  //삭제 공식문서는 아래에 적용 문장이 빠져있다 알아서 잘 붙히세용!
  calendar.on('beforeDeleteSchedule', function(event) {
    var schedule = event.schedule;
    alert('The schedule is removed.', schedule);
  calendar.deleteSchedule(schedule.id, schedule.calendarId);
  });
  //업데이트
  calendar.on('beforeUpdateSchedule', function(event) {
    var schedule = event.schedule;
    var changes = event.changes;

    calendar.updateSchedule(schedule.id, schedule.calendarId, changes);
  });
  var calendar2 = new tui.Calendar('#calendar2', {
    defaultView: 'week', // set 'week' or 'day'
    taskView: true,  // e.g. true, false, or ['task', 'milestone'])
    scheduleView: ['time'],  // e.g. true, false, or ['allday', 'time'])
  });

  //data-action의 값으로 제어
  $(function () {
    $('button').on("click", function (e) {
      e.preventDefault();
      let operation = $(this).data("action");

      if (operation === 'move-next') {
        calendar.next();
      }
      if (operation === 'move-prev') {
        calendar.prev();
      }
      if (operation === 'move-today') {
        calendar.today();
      }
    });

    $('select').on('change', function (e) {
      e.preventDefault();
      let operation = $(this).find('option:selected').data("action");
      let view = operation.split('-');
      console.log(operation);
      console.log(view);
      calendar.changeView(view[1],true);
    });
  });
</script>
 </body>
</html>
