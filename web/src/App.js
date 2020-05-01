import React from 'react';
import $ from 'jquery';
import './App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentDidMount() {
        //先执行Ajax数据请求，全局的get方法
        var source = "/reactDemo/selectList";
        this.serverRequest = $.get(source,{"offset":0,"limit":10}, function (result) {
            //alert(result);
            this.setState({
                result
            });
        }.bind(this));
    }

    //组件的render方法
    render() {
        let {result = []} = this.state;
        return (
            <div>
                <div>
                    <h1>SpringBoot React Demo</h1>
                </div>
                <div>
                    <table className='table'>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                        </tr>
                        </thead>
                        <tbody>
                        {result.map(({id, name,sex,age}) =>
                            <tr>
                                <td>{id}</td>
                                <td>{name}</td>
                                <td>{sex}</td>
                                <td>{age}</td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default App;
