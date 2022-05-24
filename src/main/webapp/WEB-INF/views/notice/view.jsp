<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-6" id="grid1"><h2>공지사항</h2></div>

<script type="text/javascript">
let noticeDate = [
	{
		noticeIdx: '1',
		title: "류승룡",
		employee:"싸이",
		employeeIdx: "1"
	},
	{
		noticeIdx: '2',
		title: "집에 못가 히히~",
		employee:"싸이",
		employeeIdx: "1"
	},
	{
		noticeIdx: '3',
		title: "집에 못가 히히~",
		employee:"싸이",
		employeeIdx: "1"
	},
	{
		noticeIdx: '4',
		title: "집에 못가 히히~",
		employee:"싸이",
		employeeIdx: "1"
	},
	{
		noticeIdx: '5',
		title: "집에 못가 히히~",
		employee:"싸이",
		employeeIdx: "1"
	},
	{
		noticeIdx: '6',
		title: "사실 이미집!",
		employee:"강남",
		employeeIdx: "2"
	}
]

const grid1 = new tui.Grid({
        el: document.getElementById('grid1'),
        data: noticeDate,
        scrollX: false,
        scrollY: false,
        columns: [
        {
            header: 'No',
            name: 'noticeIdx',
            sortingType: 'desc',
            sortable: true
        },
        {
            header: '제목',
            name: 'title'
        },
        {
            header: '작성자',
            name: 'employee'
        }
        ,
        {
            header: '작성자IDX',
            name: 'employeeIdx'
        }
        ]
    });
	grid1.hideColumn("employeeIdx",true);
	
	grid1.on('click', (ev) => {
		console.log(ev);
        let rowKey = ev.rowKey;
        let columnName = ev.columnName;
        let data = grid1.getValue(rowKey,columnName);
        if (columnName==="title") {
        	data = grid1.getValue(rowKey,"noticeIdx");
            location.href=`/board/${'${data}'}`
        }
        if (columnName==="employee") {
        	data = grid1.getValue(rowKey,"employeeIdx");
            location.href=`/user/${'${data}'}`
        }
	});
</script>