import React from 'react'

export default class RepoGrid extends React.Component {
    render = ()=> {
        return (
            <ul className = "popular-list">
                {this.props.repos.map((repo,index)=>{
                  return (
                    <li
                      key={repo.name}
                      className="popular-item"
                    >
                      <div className="popular-rank">#{index + 1}</div>
                      <ul className="space-list-items">
                        <li>
                          <img
                            className="avatar"
                            src={repo.owner.avatar_url}
                            alt={`Avatar for ${repo.owner.login}`}
                          />
                        </li>
        
                        <li>
                          <a href={repo.html_url} target="_blank">
                            {repo.name}
                          </a>
                        </li>
                        <li>@{repo.owner.login}</li>
                        <li>{repo.stargazers_count} stars</li>
                      </ul>
                    </li>
                  );
                })}
            </ul>
        )
    }
}