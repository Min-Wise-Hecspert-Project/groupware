<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-md-6" id="notice-grid">
	<h2>공지사항</h2>
</div>
<script type="text/javascript">
	let noticeGrid = "";
	let widthBoolean = false;
	$(function () {
		// 그리드 반응형을 위한 동작 트리거 함수
		const widthControl = boolean => {
			if (boolean === true) {
				let notice = $("#notice-grid")
				notice.removeClass("col-md-6");
				notice.addClass("col-md-12");
				let width = notice.width();
				noticeGrid.setWidth(width);
				$("#notice-grid").resize(function () {
					notice = $("#notice-grid")
					let width = notice.width();
					noticeGrid.setWidth(width);
					console.log("active resize")
				});
			}
		}
	
		//??
	 	class RowNumberRenderer {
	      constructor(props) {
			//console.log(`props`, props);
	        const el = document.createElement('span');
	        props.formattedValue = props.grid.store.data.rawData[props.rowKey].noticeIdx;
	        el.innerHTML =  props.formattedValue;
	        
	        this.el = el; 
	      }
	
	      getElement() {
	        return this.el;
	      }
	
	      render(props) {
	    	// el.innerHTML =  props.formattedValue;
	      }
	    }

		// 비동기 통신 요청
		var requestOptions = {
			method: 'GET',
			redirect: 'follow'
		};
		fetch("http://localhost:8080/api/notice?sorting=6", requestOptions)
			.then(response => response.json())
			.then(result => {
				let noticeGridDate = new Array();
				//toast grid에 사용하기 위해 header정보와 맞게 데이터 파싱
				for (let i = 0; i < result.length; i++) {
					let data = new Object;
					//console.log('데이터', result[i]);
					data.noticeIdx = result[i].noticeIdx
					data.employeeIdx = result[i].employeeIdx
					data.title = result[i].title
					data.name = result[i].employeeDTO.name
					noticeGridDate.push(data);
				}

				
				noticeGrid = new tui.Grid({
					el: document.getElementById('notice-grid'),
					data: noticeGridDate,
					scrollX: false,
					scrollY: false,
					rowHeaders: [{
						type: 'rowNum',
						renderer: {
							type: RowNumberRenderer
						}
					}],
					columns: [
						{
							header: 'No',
							name: 'noticeIdx',
						},
						{
							header: '제목',
							name: 'title'
						},
						{
							header: '작성자',
							name: 'name',
							width:150
						}
						,
						{
							header: '작성자IDX',
							name: 'employeeIdx'
						}
					],

				});
				// 값을 위한 idx 숨기기
				noticeGrid.hideColumn("employeeIdx", true);
				noticeGrid.hideColumn("noticeIdx", true);
				// 그리드 click 이벤트
				noticeGrid.on('click', (ev) => {
					let rowKey = ev.rowKey;
					let columnName = ev.columnName;
					let data = noticeGrid.getValue(rowKey, columnName);
					if (columnName === "title") {
						data = noticeGrid.getValue(rowKey, "noticeIdx");
						location.href = `/notice/${'${data}'}`
					}
					if (columnName === "name") {
						data = noticeGrid.getValue(rowKey, "employeeIdx");
						location.href = `/user/${'${data}'}`
					}
				});
				// 마우스 커서 이벤트
				noticeGrid.on('mouseover', (ev) => {
					if ((ev.columnName === "name" || ev.columnName === "title") && ev.targetType === "cell") {
						$('html').css('cursor', 'pointer');
					} else {
						$('html').css('cursor', 'auto');
					}
				});
				//반응형 함수 동작
				widthControl(widthBoolean);
			})
			.catch(error => console.log('error', error));
	});



</script>