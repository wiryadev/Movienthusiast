# Movienthusiast

## BDD Specs

### Story: Users wants to see list movies that are currently showing in cinema

### Narrative #1

```
As an online user
I want the app to load now playing movies list when opened
So I know whhat movies that are currently showing in cinema
```

#### Scenarios (Acceptance criteria)

```
Given the user has connectivity
When the user open the app
Then the app should display the currently showing movies from remote
```

### Narrative #2

```
As an offline user
I want the app to show related error code
So I know what went wrong
```

#### Scenarios (Acceptance criteria)

```
Given the customer doesn't have connectivity
When the user open the app
Then the app should display error code in screen
```

### Payload contract

```
GET /movie/now_playing
200 RESPONSE
{
	"results": [
    {
      "id": 980078,
      "overview": "Christopher Robin is headed off to college and he has abandoned his old friends, Pooh and Piglet, which then leads to the duo embracing their inner monsters.",
      "poster_path": "/fNTtVbqI92abEKAgz2ynurCUne.jpg",
      "title": "Winnie the Pooh: Blood and Honey",
    },
  ]
}
```
