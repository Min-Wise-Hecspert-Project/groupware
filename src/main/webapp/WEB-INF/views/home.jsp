<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="includes/head.jsp"></jsp:include>
<title>ERP HOME</title>
</head>
<body>
  <jsp:include page="includes/header.jsp"></jsp:include>
  <div class="container-fluid">
    <div class="row">
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
        <div
          class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
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


        <div class="content">
          <div class="row align-items-start">

            <jsp:include page="notice/view.jsp"></jsp:include>

            <div class="col-md-6">
              <h2>회사일정</h2>
              <div id="menu">
                <span id="menu-navi">
                  <button type="button" class="btn btn-default btn-sm move-today"
                    data-action="move-today">Today</button>
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
            <div class="col-md-6" id="grid3">
              <h2>게시판</h2>
            </div>
            <div class="col-md-6">
              <h2>임원일정</h2>
              <div id="menu">
                <span id="menu-navi">
                  <button type="button" class="btn btn-default btn-sm move-today"
                    data-action="move-today">Today</button>
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
    const gridData = [{
      name: 'qwe',
      artist: '<a href = "https://www.notion.so">이동확인</a>'
    }, {
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
    calendar.on('beforeDeleteSchedule', function (event) {
      var schedule = event.schedule;
      alert('The schedule is removed.', schedule);
      calendar.deleteSchedule(schedule.id, schedule.calendarId);
    });
    //업데이트
    calendar.on('beforeUpdateSchedule', function (event) {
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
        calendar.changeView(view[1], true);
      });
    });
  </script>
  </body>

  </html>