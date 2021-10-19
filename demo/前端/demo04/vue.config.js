//跨域代理
let proxyObj={};

proxyObj['/']={
    ws: false, //webstock
    target:'http://localhost:8080',//代理对象
    changeOrigin: true,
    pathRewrite: {
        '^/': ''
    }
}
//vue项目启动端口
module.exports={
    devServer:{
        host: 'localhost',
        port: 8088,
        proxy: proxyObj
    }
}
