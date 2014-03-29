FreeSound4J
===========

FreeSound4J is a very light API over the FreeSound.org project API.

It will initially support v1 of the api (http://www.freesound.org/docs/api/overview_apiv1.html)

Usage
=====

The API is represented uing JAX-RS annotations and Jackson JSON annotations. The api client uses the Apache CXF JAX-RS client and the Jackson JSON library.

```
    FreeSoundApi api = FreeSoundApi.Factory.create();
    Sound sound = api.getSound(83295, API_KEY);
    User user = sound.getUser();
```

API Key
=======

You will require an API key issued by FreeSound.org in order to use the API.

http://www.freesound.org/docs/api/


License
=======

Something very free, naturally...
