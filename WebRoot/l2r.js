'use strict';

(function($){

  $(function() {

    var datascource = {
      "name" : '3', "title" : '袁丹', children : [{"name" : '34', "title" : '杨简', children : [{"name" : '66', "title" : '刘福昌', leaf : true},{"name" : '29', "title" : '刘梦芸', leaf : true},{"name" : '44', "title" : '黄薇', leaf : true}]},{"name" : '42', "title" : '钟辉萍', children : [{"name" : '21', "title" : '王宇', children : [{"name" : '87', "title" : '熊卫华', children : [{"name" : '22', "title" : '周媛', children : [{"name" : '86', "title" : '何山', leaf : true},{"name" : '25', "title" : '龙倩', leaf : true},{"name" : '26', "title" : '万鹏', leaf : true},{"name" : '73', "title" : '朱珊', leaf : true},{"name" : '61', "title" : '李珺', leaf : true}]}]}]}]},{"name" : '5', "title" : '袁也', children : [{"name" : '58', "title" : '夏自翔', children : [{"name" : '32', "title" : '古文杰', children : [{"name" : '78', "title" : '兰明杰', leaf : true},{"name" : '33', "title" : '傅超', leaf : true},{"name" : '13', "title" : '陈子华', leaf : true},{"name" : '65', "title" : '李俊', leaf : true},{"name" : '45', "title" : '泛微测试', leaf : true}]}]}]},{"name" : '4', "title" : '毛凯波', children : [{"name" : '19', "title" : '贺茜茸', children : [{"name" : '77', "title" : '成沙', leaf : true}]},{"name" : '10', "title" : '张惠星', children : [{"name" : '23', "title" : '李银波', leaf : true},{"name" : '27', "title" : '陈慧', leaf : true},{"name" : '11', "title" : '曾杰', leaf : true},{"name" : '12', "title" : '杨杰', leaf : true},{"name" : '50', "title" : '徐薇婷', leaf : true}]}]},{"name" : '71', "title" : '周曼', children : [{"name" : '7', "title" : '廖琛', children : [{"name" : '79', "title" : '杨玲', leaf : true},{"name" : '9', "title" : '刘宇瀚', leaf : true},{"name" : '15', "title" : '伍惠', leaf : true}]}]},{"name" : '76', "title" : '蒋维', children : [{"name" : '81', "title" : '伍咏梅', children : [{"name" : '31', "title" : '刘黎丽', leaf : true},{"name" : '62', "title" : '欧俊', children : [{"name" : '38', "title" : '钟势权', leaf : true},{"name" : '82', "title" : '李娜', leaf : true},{"name" : '83', "title" : '夏慧', leaf : true},{"name" : '16', "title" : '王林波', leaf : true}]}]}]},{"name" : '55', "title" : '项凌峰', leaf : true},{"name" : '20', "title" : '靖凯', leaf : true},{"name" : '49', "title" : '潘佩仪', leaf : true},{"name" : '48', "title" : '雷洁琼', leaf : true},{"name" : '47', "title" : '舒鸿奉', leaf : true},{"name" : '46', "title" : '李润林', leaf : true},{"name" : '51', "title" : '王薇', leaf : true}]
    };

    $('#chart-container').orgchart({
      'data' : datascource,
      'nodeContent': 'title',
      'direction': 'l2r'
    });

  });

})(jQuery);