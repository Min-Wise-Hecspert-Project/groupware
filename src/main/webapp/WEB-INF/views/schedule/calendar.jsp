<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <select name="" id="" class="form-select-sm">
      <option value="" data-action="change-month">월</option>
      <option value="" data-action="change-week">주</option>
      <option value="" data-action="change-day">일</option>
    </select>
    <div class="row">
   	 <div class="col form-check form-switch">
      <input class="col form-check-input" type="checkbox" role="switch" id="company" value="company" checked>
      <label class="form-check-label" for="flexSwitchCheckChecked">회사 일정</label>
    </div>
    <div class="col form-check form-switch">
      <input class="form-check-input" type="checkbox" role="switch" id="department" value="department" checked>
      <label class="form-check-label" for="flexSwitchCheckChecked">부서 일정</label>
     
    </div>
    <div class="col form-check form-switch">
      <input class="form-check-input" type="checkbox" role="switch" id="executive" value="executive" checked>
      <label class="form-check-label" for="flexSwitchCheckChecked">임원 일정</label>
    </div>
    <div class="col form-check form-switch">
      <input class="form-check-input" type="checkbox" role="switch" id="my" value="my" checked>
      <label class="form-check-label" for="flexSwitchCheckChecked">나의 일정</label>
    </div>
    </div>
   
  </span>
  <span id="renderRange" class="render-range"></span>
</div>
<div id="calendar"></div>

<script>
  // 캘린더를 생성하는 방법! 아래 옵션은 popup을 활성화
  var calendar = new tui.Calendar('#calendar', {
    defaultView: 'month',
    useCreationPopup: true,
    useDetailPopup: true
  });

  //TODO: table 만들어서 CRUD 할 수 있게 생성할것!
  calendar.setCalendars([
    {
      id: 'Company Subject',
      name: '회사 일정',
      color: '#ffffff',
      bgColor: '#ff5583',
      dragBgColor: '#ff5583',
      borderColor: '#ff5583'
    },
    {
      id: 'Department Subject',
      name: '부서 일정',
      color: '#ffffff',
      bgColor: '#ffbb3b',
      dragBgColor: '#ffbb3b',
      borderColor: '#ffbb3b'
    },
    {
      id: 'Executive Subject',
      name: '임원 일정',
      color: '#ffffff',
      bgColor: '#03bd9e',
      dragBgColor: '#03bd9e',
      borderColor: '#03bd9e'
    },
    {
      id: 'My Subject',
      name: '나의 일정',
      color: '#ffffff',
      bgColor: '#03ff9e',
      dragBgColor: '#03ff9e',
      borderColor: '#03ff9e'
    }
  ]);




  $(function () {
    var setRequestOptions = {
      method: 'get',
      redirect: 'follow'
    };
    fetch("http://localhost:8080/api/schedule", setRequestOptions)
      .then(response => response.json())
      .then(result => {
        console.log(result);
        result.forEach(element => {
          const schedule = {
            calendarId: element.calendarId,
            id: element.scheduleIdx,
            title: element.title,
            isAllDay: element.isAllDay,
            start: element.startDate,
            end: element.endDate,
            attendees: element.participant,
            category: element.state === 1 ? 'allday' : 'time',
            location: element.location
          };
          calendar.createSchedules([schedule]);
        });

      })
      .catch(error => console.log('error', error));
  });

  $('.form-check-input').on("click" ,function (e) { 
    
   
    calendar.toggleSchedules("Company Subject", !$("#company").is(":checked"), true);
    calendar.toggleSchedules("Department Subject", !$("#department").is(":checked"), true);
    calendar.toggleSchedules("Executive Subject", !$("#executive").is(":checked"), true);
    calendar.toggleSchedules("My Subject", !$("#my").is(":checked"), true);
   
    
  });

  //생성
  calendar.on('beforeCreateSchedule', scheduleData => {

    var formdata = new FormData();
    console.log(scheduleData);
    formdata.append("title", scheduleData.title);
    formdata.append("content", scheduleData.content);
    formdata.append("employeeIdx", "1");
    formdata.append("startDate", scheduleData.start._date);
    console.log(scheduleData.start._date);
    formdata.append("endDate", scheduleData.end._date);
    formdata.append("state", "0");
    formdata.append("calendarId", scheduleData.calendarId);
    formdata.append("location", scheduleData.location);
    formdata.append("place", scheduleData.location);
    formdata.append("file", "없음");
    formdata.append("participant", scheduleData.attendees);

    var requestOptions = {
      method: 'POST',
      body: formdata,
      redirect: 'follow'
    };

    fetch("http://localhost:8080/api/schedule", requestOptions)
      .then(response => response.json())
      .then(result => {
        console.log(result);
        const schedule = {
          calendarId: result.calendarId,
          id: result.scheduleIdx,
          title: result.title,
          isAllDay: result.isAllDay,
          start: result.startDate,
          end: result.endDate,
          attendees: result.participant,
          category: result.state === 1 ? 'allday' : 'time',
          location: result.location
        };
        calendar.createSchedules([schedule]);
      })
      .catch(error => console.log('error', error));


    alert('일정 생성 완료');
  });
  //삭제 공식문서는 아래에 적용 문장이 빠져있다 알아서 잘 붙히세용!
  calendar.on('beforeDeleteSchedule', function (event) {
    var schedule = event.schedule;

    var deleteRequestOptions = {
      method: 'DELETE',
      redirect: 'follow'
    };

    fetch("http://localhost:8080/api/schedule/" + schedule.id, deleteRequestOptions)
      .then(response => response.text())
      .then(result => {
        console.log(result);
        calendar.deleteSchedule(schedule.id, schedule.calendarId);
      })
      .catch(error => console.log('error', error));

  });
  //업데이트 todo chages는 변경된 값만 나온다!
  calendar.on('beforeUpdateSchedule', function (event) {
    var schedule = event.schedule;
    var changes = event.changes;
    console.log(`event`, event);

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
      "scheduleIdx": schedule.id,
      "employeeIdx": "1",
      "state": 0,
      "title": changes?.title == undefined ? schedule.title:changes?.title,
      "content": "update!",
      "calendarId": changes?.calendarId == undefined ? schedule.calendarId:changes?.calendarId,
      "location": changes?.location == undefined ? schedule.location:changes?.location,
      "place": "우리",
      "startDate": changes?.start?._date == undefined ? schedule.start._date :changes?.start?._date,
      "endDate": changes?.end?._date == undefined ? schedule.end._date :changes?.end?._date,
      "file": "",
      "participant": ""
    });

    var requestOptions = {
      method: 'PUT',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };

    fetch("http://localhost:8080/api/schedule", requestOptions)
      .then(response => response.text())
      .then(result => {
        calendar.updateSchedule(schedule.id, schedule.calendarId, changes);
      })
      .catch(error => console.log('error', error));
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