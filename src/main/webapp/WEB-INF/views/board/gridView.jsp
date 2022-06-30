<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="board-grid">
	<h2>게시판</h2>
</div>
<script type="text/javascript">
	let boardGrid = "";
	$(function () {
		
		//??
		class RowNumberRenderer {
			constructor(props) {
				//console.log(`props`, props);
				const el = document.createElement('span');
				props.formattedValue = props.grid.store.data.rawData[props.rowKey].boardIdx;
				el.innerHTML = props.formattedValue;

				this.el = el;
			}

			getElement() {
				return this.el;
			}

			render(props) {
				this.el.innerHTML =  props.formattedValue;
			}
		}
		let boardDate =[];
		var requestOptions = {
			method: 'GET',
			redirect: 'follow'
			};

			fetch("http://localhost:8080//api/board/list", requestOptions)
			.then(response => response.json())
			.then(result => {
				let boardGridDate = new Array();
				//toast grid에 사용하기 위해 header정보와 맞게 데이터 파싱
				for (let i = 0; i < result.length; i++) {
					let data = new Object;
					console.log('데이터', result[i]);
					data.boardIdx = result[i].boardIdx
					data.employeeIdx = result[i].employeeIdx
					data.title = result[i].title
					boardGridDate.push(data);
				}

				console.log(boardGridDate);
				boardGrid = new tui.Grid({
					el: document.getElementById('board-grid'),
					data: boardGridDate,
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
							name: 'boardIdx',
						},
						{
							header: '제목',
							name: 'title'
						},
						{
							header: '작성자',
							name: 'employeeIdx',
							width: 150
						}
						,
						{
							header: '작성자IDX',
							name: 'employeeIdx'
						}
					],

				});
				// 값을 위한 idx 숨기기
				boardGrid.hideColumn("employeeIdx", true);
				boardGrid.hideColumn("boardIdx", true);
				// 그리드 click 이벤트
				boardGrid.on('click', (ev) => {
					let rowKey = ev.rowKey;
					let columnName = ev.columnName;
					let data = boardGrid.getValue(rowKey, columnName);
					if (columnName === "title") {
						data = boardGrid.getValue(rowKey, "boardIdx");
						location.href = `/board/${'${data}'}`
					}
					if (columnName === "name") {
						data = boardGrid.getValue(rowKey, "employeeIdx");
						location.href = `/user/${'${data}'}`
					}
				});
				// 마우스 커서 이벤트
				boardGrid.on('mouseover', (ev) => {
					if ((ev.columnName === "name" || ev.columnName === "title") && ev.targetType === "cell") {
						$('html').css('cursor', 'pointer');
					} else {
						$('html').css('cursor', 'auto');
					}
				});
			})
			.catch(error => console.log('error', error));

	
		
	
		//반응형 함수 동작
	})
</script>