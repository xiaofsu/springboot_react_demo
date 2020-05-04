import React from 'react';
import $ from 'jquery';
import './App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            id: "",
            name: "",
            sex: "",
            age: "",
            list: []
        }
        //为了在 handleFormSubmit 使用 this，需要进行绑定
        this.handleFormSubmit = this.handleFormSubmit.bind(this);
        this.resetValue = this.resetValue.bind(this);
    }


    componentDidMount() {
        //先执行Ajax数据请求，全局的get方法
        var source = "/reactDemo/selectList";
        this.serverRequest = $.get(source, {"offset": 0, "limit": 100}, function (result) {
            //alert(result);
            this.setState({
                list: result
            });
        }.bind(this));
    }


    handleFormSubmit() {

        const id = this.state.id;
        const name = this.state.name;
        const age = this.state.age;
        const sex = this.state.sex;
        if (id == "") {
            var source = "/reactDemo/addValue";
            $.post(source, {"name": name, "age": age, "sex": sex}, function (result) {
                //alert(result);
                this.resetValue()
                this.componentDidMount();
            }.bind(this));
        } else {
            var source = "/reactDemo/updateValue";
            $.post(source, {"id": id, "name": name, "age": age, "sex": sex}, function (result) {
                //alert(result);
                this.resetValue()
                this.componentDidMount();
            }.bind(this));
        }
    }

    deleteValue(id) {
        var source = "/reactDemo/delValue";
        $.post(source, {"id": id}, function (result) {
            //alert(result);
            this.resetValue()
            this.componentDidMount();
        }.bind(this));
    }

    resetValue() {
        this.setState({
            id: "",
            name: "",
            sex: "",
            age: "",
        })
    }

    //组件的render方法
    render() {
        return (
            <div className="container-fluid" style={{marginTop: '20px'}}>
                <div className="row">
                    <div className="col-xs-4 col-xs-offset-1">
                        <div className="panel panel-default">
                            <div className="panel-body">
                                <div>
                                    <div>
                                        <h1>SpringBoot React Demo</h1>
                                    </div>
                                    <div>
                                        <table className='table table-bordered'>
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>年龄</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            {
                                                this.state.list.map(item => {
                                                    return (
                                                        <tr key={item.id}>
                                                            <td>{item.id}</td>
                                                            <td>{item.name}</td>
                                                            <td>{item.sex}</td>
                                                            <td>{item.age}</td>
                                                            <td>
                                                                <button className="btn btn-primary" onClick={() => {
                                                                    this.setState({
                                                                        id: item.id,
                                                                        name: item.name,
                                                                        sex: item.sex,
                                                                        age: item.age
                                                                    })
                                                                }}>修改
                                                                </button>
                                                                <button className="btn btn-danger"
                                                                        style={{marginLeft: '5px'}}
                                                                        onClick={() => {
                                                                            this.deleteValue(item.id)
                                                                        }}>删除
                                                                </button>
                                                            </td>
                                                        </tr>
                                                    )
                                                })}
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-xs-3 col-xs-offset-1">
                        <div className="panel panel-default">
                            <div className="panel-body">
                                <div className="form-group">
                                    <label htmlFor="name" className="col-xs-3">用户名</label>
                                    <div className="col-xs-8">
                                        <input type="text" id="name" className="form-control" value={this.state.name}
                                               onChange={
                                                   (e) => {
                                                       this.setState({
                                                           name: e.target.value
                                                       })
                                                   }
                                               }/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="name" className="col-xs-3">年龄</label>
                                    <div className="col-xs-8">
                                        <input type="text" id="age" className="form-control" value={this.state.age}
                                               onChange={
                                                   (e) => {
                                                       this.setState({
                                                           age: e.target.value
                                                       })
                                                   }
                                               }/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="name" className="col-xs-3">性别</label>
                                    <div className="col-xs-8">
                                        <input type="text" id="sex" className="form-control" value={this.state.sex}
                                               onChange={
                                                   (e) => {
                                                       this.setState({
                                                           sex: e.target.value
                                                       })
                                                   }
                                               }/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-sm-offset-2 col-sm-10">
                                        <button className="btn btn-default" onClick={this.handleFormSubmit}>提交</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        );
    }
}

export default App;
