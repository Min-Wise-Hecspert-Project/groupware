<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
          <select name="" id="" class="form-select-sm">
            <option value="" data-action="change-month">월</option>
            <option value="" data-action="change-week">주</option>
            <option value="" data-action="change-day">일</option>
          </select>
        </span>
        <span id="renderRange" class="render-range"></span>
      </div>
	<div id="calendar"></div>
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
          <select name="" id="" class="form-select-sm">
            <option value="" data-action="change-month">월</option>
            <option value="" data-action="change-week">주</option>
            <option value="" data-action="change-day">일</option>
          </select>
        </span>
        <span id="renderRange" class="render-range"></span>
      </div>
	<div id="calendar2"></div>
  <script>
    // 캘린더를 생성하는 방법! 아래 옵션은 popup을 활성화
    var calendar = new tui.Calendar('#calendar', {
      defaultView: 'month',
      useCreationPopup: true,
      useDetailPopup: true
    });
    var calendar2 = new tui.Calendar('#calendar2', {
        defaultView: 'month',
        useCreationPopup: true,
        useDetailPopup: true
     });

    //생성
    calendar.on('beforeCreateSchedule', scheduleData => {
      
    var formdata = new FormData();
        formdata.append("title", scheduleData.title);
        formdata.append("content", "");
        // 파일 업로드 콜백 함수값 사용
        formdata.append("file", "없음!");
        // 로그인 구현후 추가 변경
        formdata.append("employeeIdx", "1");
        // 임시저장 구현 후 변경
        formdata.append("state", "0");

        var requestOptions = {
          method: 'POST',
          body: formdata,
          redirect: 'follow'
        };

        fetch("http://localhost:8080/api/notice", requestOptions)
          .then(response => response.json())
          .then(result => console.log(result))
          .catch(error => console.log('error', error));

      const schedule = {
        calendarId: 1,
        id: 1,
        title: scheduleData.title,
        isAllDay: scheduleData.isAllDay,
        start: scheduleData.start,
        end: scheduleData.end,
        attendees: scheduleData.attendees,
        category: scheduleData.isAllDay ? 'allday' : 'time',
        location: scheduleData.location
      };
      console.log(`scheduleData.calendarId`,scheduleData.calendarId );
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
          let data = calendar.getDate();
        	calendar2.createSchedules(data);
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
</html>